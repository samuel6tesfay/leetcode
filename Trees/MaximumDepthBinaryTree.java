package leetcode.Trees;

public class MaximumDepthBinaryTree {

    public static void main(String[] args) {
        MaximumDepthBinaryTree invertBinaryTree = new MaximumDepthBinaryTree();
        TreeNode root = new TreeNode(4);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);

        root.left = left;
        root.right = right;

        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);

        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(9);

        left.left = t3;
        left.right = t4;

        right.left = t5;
        right.right = t6;




        invertBinaryTree.maxDepth(root);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
