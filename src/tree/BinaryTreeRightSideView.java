package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
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

        List<Integer> result = rightSideView(root);
        System.out.println("result "+result);

    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result,0);
        return result;
    }

    private static void helper(TreeNode root, List<Integer> result, int level) {
        if(root == null){
            return;
        }if(level==result.size()){
            result.add(root.val);
        }
        helper(root.right,result,level+1);
        helper(root.left,result,level+1);
    }
}
