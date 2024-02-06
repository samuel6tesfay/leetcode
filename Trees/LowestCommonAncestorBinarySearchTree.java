package leetcode.Trees;

public class LowestCommonAncestorBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,p,q);
        return root;
    }

}
