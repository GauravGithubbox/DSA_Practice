package tree;

import java.util.*;
// Left --> Node --> Right
public class InorderTraversal {
    // Iterative inorder traversal method
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // List to store the traversal result
        Stack<TreeNode> stack = new Stack<>();    // Stack to manage traversal
        TreeNode curr = root;                     // Current node pointer

        // Traverse the tree
        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (curr != null) {
                stack.push(curr);                 // Push current node to stack
                curr = curr.left;                 // Move to left child
            }

            // Current must be null at this point
            curr = stack.pop();                   // Node to be visited
            result.add(curr.val);                 // Add node value to result
            curr = curr.right;                    // Consider the right subtree
        }

        return result;                            // Return the final inorder traversal
    }

    // Main method to test the inorder traversal
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

        InorderTraversal traversal = new InorderTraversal();
        List<Integer> result = traversal.inorderTraversal(root);

        // Print the inorder traversal result
        System.out.println("Inorder Traversal: " + result);
    }
}

