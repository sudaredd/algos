package ds.algos.tree.binary;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(4);
        bst.insert(7);
        bst.insert(5);
        bst.insert(3);

        List<Integer> l = new ArrayList<>();
        bst.inOrder(bst.root, l);
        System.out.println(l);
        bst.delete(bst.root, 4);
        System.out.println(bst.root);
        l = new ArrayList<>();
        bst.inOrder(bst.root, l);
        System.out.println("After deletion:" + l);
    }


    public void insert(int val) {
        Node node = new Node(val);
        if (root == null) {
            root = node;
            return;
        }
        findNode(root, node);
    }

    public void delete(Node root, int val) {
        if (root.value == val) {
            root = null;
            return;
        }
        Node current = root;
        Node parent = null;
        while (current != null && current.value != val) {
            parent = current;
            if (val < current.value)
                current = current.left;
            else
                current = current.right;
        }
        if (current == null) {
            return;
        }

        //case 1, both childs are null
        if (current.left == null && current.right == null) {
            if (parent.left == current) {
                parent.left = null;
            } else
                parent.right = null;
            //both childs are not null
        } else if (current.left != null && current.right != null) {
            Node maxPredecissorNode = findMaxPredecissorNode(current);
            int predecessorVal = maxPredecissorNode.value;
            delete(root, predecessorVal);
            current.value = predecessorVal;
            //one child is not null
        } else {
            Node child = current.left != null ? current.left : current.right;
            if (parent.left == current)
                parent.left = child;
            else
                parent.right = child;
        }

        System.out.println("current:" + root);
    }

    private Node findMaxPredecissorNode(Node current) {
        Node previous = current;
        Node predicissor = current.left;
        while (predicissor != null) {
            previous = predicissor;
            predicissor = predicissor.right;
        }
        return previous;
    }

    private void findNode(Node current, Node node) {
        Node previous = current;
        while (current != null) {
            previous = current;
            if (node.value > current.value) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        if (previous.value > node.value)
            previous.left = node;
        else
            previous.right = node;
    }

    public void inOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }
        inOrder(node.left, values);
        values.add(node.value);
        inOrder(node.right, values);
    }
}
