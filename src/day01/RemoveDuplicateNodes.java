package day01;

import java.util.HashSet;

public class RemoveDuplicateNodes {
    /*
        编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

        示例
            输入：[1, 2, 3, 3, 2, 1]
            输出：[1, 2, 3]
     */
    public static void main(String[] args) {
        // 创建测试链表：1 -> 2 -> 3 -> 2 -> 1 -> 4 -> 5 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(3);

        // 打印链表
        System.out.println("original list:");
        printList(head);

        // 去除重复节点
        head = removeDuplicateNodes(head);

        // 打印去重后的链表
        System.out.println("after removing:");
        printList(head);
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;

        HashSet<Integer> visited = new HashSet<>();
        visited.add(head.val);

        ListNode pos = head;
        while (pos.next != null) {
            ListNode cur = pos.next;
            if (visited.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

    // 打印链表
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
