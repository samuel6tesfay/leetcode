package leetcode.Trees;


public class KthSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    int count = 0;
    int result;

    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }

}
