package day08;

public class GetIntersectionNode {
    /*
        某教练同时带教两位学员，分别以链表 l1、l2 记录了两套核心肌群训练计划，节点值为训练项目编号。
        两套计划仅有前半部分热身项目不同，后续正式训练项目相同。
        请设计一个程序找出并返回第一个正式训练项目编号。如果两个链表不存在相交节点，返回 null 。
        示例 1：
                     4 -> 1
                            \
                              8 -> 4 -> 5
                            /
                5 -> 0 -> 1

                输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
                输出：Reference of the node with value = 8
                解释：第一个正式训练项目编号为 8 （注意，如果两个列表相交则不能为 0）。
                从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
                在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
        示例 2：
                输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
                输出：Reference of the node with value = 2
                解释：第一个正式训练项目编号为 2 （注意，如果两个列表相交则不能为 0）。
                从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
                在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
        示例 3：
                输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
                输出：null
                解释：两套计划完全不同，返回 null。从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
                由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     */
    public static void main(String[] args) {
        // 示例用例
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersectNode = new ListNode(8);
        headA.next.next = intersectNode;
        intersectNode.next = new ListNode(4);
        intersectNode.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersectNode;

        ListNode result = getIntersectionNode(headA, headB);
        System.out.println("相交节点的值为: " + (result != null ? result.val : "null"));
    }

    // 方法一：
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // 如果 p1 到达链表末尾，则转到 headB
            p1 = (p1 == null) ? headB : p1.next;
            // 如果 p2 到达链表末尾，则转到 headA
            p2 = (p2 == null) ? headA : p2.next;
        }
        return p1;
    }
}
