package tree;

public class BalancedBinaryTree {

    public static boolean result = true;

    public static boolean isBalanced(TreeNode root) {
        checkHeight(root);
        return result;
    }

    public static int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftCount = checkHeight(node.left);
        int rightCount = checkHeight(node.right);
        int diff = Math.abs(leftCount - rightCount);
        if (diff > 1) {
            result = false;
        }
        return 1 + Math.max(leftCount, rightCount);
    }


    public static void main(String[] args) {
        /*
            Construct the following binary tree:
                    10
                   /  \
                  5    15
                 / \     \
                3   7     18
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        boolean ans = isBalanced(root);
        System.out.println("Eiter this tree is balanced or not ? " + ans);


    }


}
