package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Node --> Left --> Right
public class PreorderTraversal {


    public List<Integer> preOrderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        helper(node.left, result);
        helper(node.right, result);
    }

    public List<Integer> preOrderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                result.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;

        }
        return result;
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

        PreorderTraversal traversal = new PreorderTraversal();
        List<Integer> result = traversal.preOrderTraversalRecursive(root);
        List<Integer> resultIterative = traversal.preOrderTraversalIterative(root);


        // Print the preorder traversal result
        System.out.println("Preorder Traversal Recursive: " + result);
        System.out.println("Preorder Traversal Iterative:" + resultIterative);
    }
}
