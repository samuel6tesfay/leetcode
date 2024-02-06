package leetcode.Trees;

public class DiameterBinaryTree {

    public static void main(String[] args) {

        // Create the root node
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(2);


        root.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);









        System.out.println(diameterOfBinaryTree(root));
    }

    static int result = -1;

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    private static int dfs(TreeNode current) {
        if (current == null) {
            return -1;
        }
//        System.out.println(6);
        int left = 1 + dfs(current.left);
//        System.out.println(7);
        int right = 1 + dfs(current.right);
        result = Math.max(result, (left + right));
        System.out.println("cur " + current.val);
        System.out.println("value  " + Math.max(left, right));


        return Math.max(left, right);
    }
}

//          2
//        /   \
//       3     4
//      / \      \
//     5   6       7
//        /  \    /
//       10   2   9