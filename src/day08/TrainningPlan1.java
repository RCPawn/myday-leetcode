package day08;

import static day08.ListNode.arrayToListNode;
import static day08.ListNode.printListNode;

public class TrainningPlan1 {
    /*
        给定一个头节点为 head 的单链表用于记录一系列核心肌群训练编号，
        请将该系列训练编号 倒序 记录于链表并返回。
        示例 1：
                输入：head = [1,2,3,4,5]
                输出：[5,4,3,2,1]
        示例 2：
                输入：head = [1,2]
                输出：[2,1]
        示例 3：
                输入：head = []
                输出：[]
     */
    public static void main(String[] args) {
        ListNode head = arrayToListNode(new int[]{1, 2, 3, 4, 5});
        printListNode(trainningPlan(head));
    }

    public static ListNode trainningPlan(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            // 暂存当前节点的下一个节点
            ListNode next = cur.next;
            // 将当前节点的 next 指针指向前一个节点（实现倒序）
            cur.next = pre;
            // 将 pre 和 cur 指针分别向前移动
            pre = cur;     // pre 移动到当前节点
            cur = next;    // cur 移动到原来的下一个节点
        }
        return pre;
    }
}
