package ds.algos.ice;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    Node root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(4);
        binaryTree.insert(12);
        binaryTree.insert(6);
        System.out.println(binaryTree.root);
        binaryTree.delete(5);
        System.out.println(binaryTree.root);

        List<Integer> l = new ArrayList<>();
        binaryTree.insert(5);
        System.out.println(binaryTree.root);
        binaryTree.inOrder(binaryTree.root, l);
        System.out.println("in order ::"+l);
        int sumOfAll = sumOfAllNodes(binaryTree.root);
        System.out.println("sumOfAll::"+sumOfAll);
        int sumAtK = sumOfAllNodesAtLevelN(binaryTree.root, 1);
        System.out.println("sumAtK::"+sumAtK);
        int maxLevel = maxLevel(binaryTree.root);
        System.out.println("maxLevel::"+maxLevel);
    }

    private static int maxLevel(Node root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxLevel(root.left), maxLevel(root.right));
    }

    private static int sumOfAllNodes(Node root) {
        if(root == null)
            return 0;
        return sumOfAllNodes(root.left) + root.val + sumOfAllNodes(root.right);
    }

    private static int sumOfAllNodesAtLevelN(Node root, int i) {
        if(root == null)
            return 0;
        if(i==0)
            return root.val;

        return sumOfAllNodesAtLevelN(root.left, i-1) + sumOfAllNodesAtLevelN(root.right, i-1 );

    }

    private void inOrder(Node root, List<Integer> l) {
        if(root == null)
            return;
        inOrder(root.left, l);
        l.add(root.val);
        inOrder(root.right, l);
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (root == null) {
            root = node;
        } else {
            Node prev = findPreviousNode(root, val);
            if (node.val > prev.val) {
                prev.right = node;
            } else
                prev.left = node;
        }
    }

    public void delete(int val) {

        Node parent = findParent(root, val);
        Node node = parent.left.val == val ? parent.left : parent.right;
        if (node.left == null && node.right == null) {
            if (parent.left == node)
                parent.left = null;
            else parent.right = null;
        } else if (node.left != null && node.right != null) {
            Node minNode = findMinNode(node.right);
            delete(minNode.val);
            node.val = minNode.val;
        } else if (node.left != null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else
                parent.right = node.left;
        } else if (node.right != null) {
            if (parent.left == node) {
                parent.left = node.right;
            } else
                parent.right = node.right;
        }
    }

    private Node findMinNode(Node node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node findPreviousNode(Node root, int val) {
        Node prev = null;
        Node current = root;
        while (current != null) {
            prev = current;
            if (val > current.val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return prev;
    }

    private Node findParent(Node root, int val) {
        Node current = root;
        while (current != null) {
            if((current.left != null && current.left.val==val) || (current.right != null && current.right.val==val)  ) {
                return current;
            }else if (val > current.val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return current;
    }
}
