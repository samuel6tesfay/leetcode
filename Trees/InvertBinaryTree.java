package leetcode.Trees;

public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
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




        invertBinaryTree.invertTree(root);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.right = invertTree(root.left);
        node.left = invertTree(root.right);
        return node;
    }
}
