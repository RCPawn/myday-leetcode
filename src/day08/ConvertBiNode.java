package day08;

public class ConvertBiNode {
    /*
        二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
        实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，
        转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
        返回转换后的单向链表的头节点。
        示例：
            输入： [4,2,5,1,3,null,6,0]
            输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
     */
    public static void main(String[] args) {
        // 构建二叉搜索树
        int[] vals = {4, 2, 5, 1, 3, 0, 6};  // 给定的节点值
        TreeNode root = TreeNode.createBST(vals);

        // 转换为单向链表
        ConvertBiNode converter = new ConvertBiNode();

        // 输出单向链表的节点值
        TreeNode cur = converter.convertBiNode(root);
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    private final TreeNode head = new TreeNode(-1);  // 哨兵节点，作为链表头的前一个节点
    private TreeNode prev = head;              // 记录当前链表的尾节点

    public TreeNode convertBiNode(TreeNode root) {
        inOrder(root);
        return head.right;  // 返回哨兵节点的右节点，即链表的头节点
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 递归处理左子树
        inOrder(node.left);

        // 将当前节点连接到链表中
        prev.right = node;
        node.left = null;   // 将左子节点设为 null

        // 移动链表尾节点的指针
        prev = node;

        // 递归处理右子树
        inOrder(node.right);
    }
}
