package tree;

import java.util.List;

public class DeleteNodeInBST {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to delete found
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Node with two children: get the inorder successor (smallest in the right subtree)
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val; // Copy value
            root.right = deleteNode(root.right, minNode.val); // Delete the inorder successor
        }

        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }



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

        int val = 2;
        TreeNode updatedRoot = deleteNode(root, val);

        InorderTraversal traversal = new InorderTraversal();
        List<Integer> result = traversal.inorderTraversal(updatedRoot);

        // Print the inorder traversal result
        System.out.println("Inorder Traversal: " + result);  // Should print: [1, 2, 3, 4, 5, 7]
    }


}
