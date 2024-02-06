package leetcode.Trees;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreePreorderInorderTraversal {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder , int inStart, int inEnd, Map<Integer,Integer> map) {

        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootPosition = map.get(root.val);
        root.left = buildTree(preorder,preStart+1,rootPosition+preStart-inStart,inorder,inStart,rootPosition-1,map);
        root.right = buildTree(preorder,rootPosition+preStart-inStart+1,preEnd,inorder,rootPosition+1,inEnd,map);

        return root;
    }
}
