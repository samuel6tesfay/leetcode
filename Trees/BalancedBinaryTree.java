package leetcode.Trees;

import java.util.Map;

public class BalancedBinaryTree {

    public static void main(String[] args) {

    }

    private static Map.Entry<Boolean,Integer> dfs(TreeNode root){

        if (root == null) {
            return  Map.entry(true,0);
        }
        var left = dfs(root.left);
        var right = dfs(root.right);
        var balanced =
                left.getKey() &&
                        right.getKey() &&
                        (Math.abs(left.getValue() - right.getValue()) <= 1);
        return Map.entry(balanced,1 + Math.max(left.getValue(), right.getValue()));
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).getKey();
    }
}
