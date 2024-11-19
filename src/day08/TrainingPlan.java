package day08;

import static day08.ListNode.arrayToListNode;

public class TrainingPlan {
    /*
        给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，
        请查找并返回倒数第 cnt 个训练项目编号。
        示例 1：
                输入：head = [2,4,7,8], cnt = 1
                输出：8
     */
    public static void main(String[] args) {
        ListNode head = arrayToListNode(new int[]{2, 4, 7, 8});
        System.out.println(trainingPlan(head, 1).val);
    }

    public static ListNode trainingPlan(ListNode head, int cnt) {
        ListNode l = head, r = head;
        // 让 r 先前进 cnt 步
        for (int i = 0; i < cnt; i++) {
            if (r != null)
                r = r.next;
        }
        // r 和 l 同时前进，直到 r 到达链表末尾
        while (r != null) {
            r = r.next;
            l = l.next;
        }
        return l;
    }
}
