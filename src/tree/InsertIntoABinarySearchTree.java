package tree;

import java.util.List;

public class InsertIntoABinarySearchTree {
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

        int val = 5;
        TreeNode updatedRoot = insertIntoBST(root, val);

        InorderTraversal traversal = new InorderTraversal();
        List<Integer> result = traversal.inorderTraversal(updatedRoot);

        // Print the inorder traversal result
        System.out.println("Inorder Traversal: " + result);  // Should print: [1, 2, 3, 4, 5, 7]
    }

    private static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
