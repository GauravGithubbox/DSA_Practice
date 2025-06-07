package tree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    private List<Integer> preOrderTraversalIterative(TreeNode root) {
        return null;
    }

    private List<Integer> preOrderTraversalRecursive(TreeNode root) {
     List<Integer> result = new ArrayList<>();
     helper(result,root);
     return result;
    }

    private void helper(List<Integer> result, TreeNode root) {
        if(root==null){
            return;
        }
        helper(result,root.left);
        helper(result,root.right);
        result.add(root.val);
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

        PostorderTraversal traversal = new PostorderTraversal();
        List<Integer> result = traversal.preOrderTraversalRecursive(root);
        List<Integer> resultIterative = traversal.preOrderTraversalIterative(root);


        // Print the preorder traversal result
        System.out.println("Postorder Traversal Recursive: " + result);
        System.out.println("Postorder Traversal Iterative:" + resultIterative);
    }


}
