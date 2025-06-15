package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class BinaryTreeLevelOrderTraversal {
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

        List<List<Integer>> result = levelOrder(root);
        System.out.println("result="+result);

    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at this level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            result.add(level);
        }

        return result;
    }
}
