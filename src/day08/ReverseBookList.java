package day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import static day08.ListNode.arrayToListNode;

public class ReverseBookList {
    /*
        书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。
        为更方便整理书架，店员需要将书单倒过来排列，
        就可以从最后一本书开始整理，逐一将书放回到书架上。
        请倒序返回这个书单链表。
        示例 1：
                输入：head = [3,6,4,1]
                输出：[1,4,6,3]
     */
    public static void main(String[] args) {
        ListNode head = arrayToListNode(new int[]{3, 6, 4, 1});
        System.out.println(Arrays.toString(reverseBookList(head)));
    }

    // 方法一：
    public static int[] reverseBookList(ListNode head) {
        ListNode pre = null, cur = head;
        int i = 0, n = 0;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n++;
        }
        int[] res = new int[n];
        while (pre != null) {
            res[i++] = pre.val;
            pre = pre.next;
        }
        return res;
    }

    // 方法二：
    public static int[] reverseBookList1(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.removeLast();
        return res;
    }

    // 方法三：
    static ArrayList<Integer> tmp = new ArrayList<>();
    public static int[] reverseBookList2(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    public static void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }
}
