package tree;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        /*
              Original BST:
                    4
                   / \
                  2   7
                 / \
                1   3
        */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int result = goodNodes(root);
        System.out.println("result " + result);

    }

    private static int goodNodes(TreeNode root) {
        return helper(root, 0, Integer.MIN_VALUE);
    }

    private static int helper(TreeNode root, int ans, int curMax) {
        if (root == null) {
            return 0;
        }
        int rootAnswer = 0;
        if (root.val >= curMax) {
            rootAnswer = 1;
            curMax = root.val;
        }
        int lans = helper(root.left, ans, curMax);
        int rans = helper(root.right, ans, curMax);
        return lans + rans + rootAnswer;
    }
}
