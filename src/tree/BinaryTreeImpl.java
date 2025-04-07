package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeImpl {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        // pre-order implementation
        public void preOrder(Node root) {
            if (root == null) {
                System.out.println(-1);
                return;
            }
            System.out.println(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        // in-order implementation
        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.println("In-Order" + root.data);
            inOrder(root.right);
        }

        // post-order implementation
        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.println("Post-Order" + root.data);
        }

        // Level -order implementation
        public void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()) {
                Node currNode = queue.remove();
                if (currNode == null) {
                    System.out.println();
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        queue.add(null);
                    }
                } else {
                    System.out.println("level order ->" + currNode.data);
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                }
            }
        }

        // height of the tree
        public Integer height(Node node) {
            if (node == null) {
                return 0;
            }
            int lh = height(node.left);
            int rh = height(node.right);
            return Math.max(lh, rh) + 1;
        }

        // count node
        public Integer countNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int lc = countNodes(root.left);
            int rc = countNodes(root.right);
            return lc + rc + 1;
        }

        public Integer sum(Node root) {
            if (root == null) {
                return 0;
            }
            int ls = sum(root.left);
            int rs = sum(root.right);
            return ls + rs + root.data;
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
                /*     1
                      / \
                     2   3
                    / \    \
                   4   5    6
                                          */

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("tree root =>" + root.data);
        tree.preOrder(root);
        tree.inOrder(root);
        tree.postOrder(root);
        tree.levelOrder(root);
        int height = tree.height(root);
        System.out.println("height = >" + height);
        int count = tree.countNodes(root);
        System.out.println("count tree nodes =>" + count);
        int sum = tree.sum(root);
        System.out.println("sum of tree nodes =>" + sum);
    }
}
