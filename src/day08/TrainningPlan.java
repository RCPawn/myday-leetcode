package day08;

import static day08.ListNode.arrayToListNode;
import static day08.ListNode.printListNode;

public class TrainningPlan {
    /*
        给定两个以 有序链表 形式记录的训练计划 l1、l2，
        分别记录了两套核心肌群训练项目编号，
        请合并这两个训练计划，按训练项目编号 升序 记录于链表并返回。
        注意：新链表是通过拼接给定的两个链表的所有节点组成的。
        示例 1：
                输入：l1 = [1,2,4], l2 = [1,3,4]
                输出：[1,1,2,3,4,4]
        示例 2：
                输入：l1 = [], l2 = []
                输出：[]
        示例 3：
                输入：l1 = [], l2 = [0]
                输出：[0]
     */
    public static void main(String[] args) {
        ListNode l1 = arrayToListNode(new int[]{1, 2, 4});
        ListNode l2 = arrayToListNode(new int[]{1, 3, 4});
        printListNode(trainningPlan(l1, l2));
    }

    public static ListNode trainningPlan(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
