package day08;

import static day08.ListNode.arrayToListNode;

public class KthToLast {
    /*
        实现一种算法，找出单向链表中倒数第 k 个节点。
        返回该节点的值。
        示例：
            输入： 1->2->3->4->5 和 k = 2
            输出： 4
     */
    public static void main(String[] args) {
        ListNode head = arrayToListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(kthToLast(head, 2));
    }

    public static int kthToLast(ListNode head, int k) {
        ListNode l = head, r = head;
        for (int i = 0; i < k; i++) {
            r = r.next;
        }
        while (r != null) {
            r = r.next;
            l = l.next;
        }
        return l.val;
    }
}
