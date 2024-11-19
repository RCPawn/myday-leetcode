package day08;

// TreeNode 类定义
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    // 辅助方法：构建二叉搜索树
    public static TreeNode createBST(int[] values) {
        TreeNode root = null;
        for (int value : values)
            root = insert(root, value);
        return root;
    }

    // 辅助方法：插入节点
    private static TreeNode insert(TreeNode node, int value) {
        if (node == null)
            return new TreeNode(value);
        if (value < node.val)
            node.left = insert(node.left, value);
        else
            node.right = insert(node.right, value);
        return node;
    }
}