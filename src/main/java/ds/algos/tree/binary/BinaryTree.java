package ds.algos.tree.binary;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.create();
        List<Integer> list = new ArrayList<>();
        binaryTree.inOrder(root, list);
        System.out.println("In Order:"+list);

        list = new ArrayList<>();
        binaryTree.preOrder(root, list);
        System.out.println("Pre Order:"+list);

        list = new ArrayList<>();
        binaryTree.postOrder(root, list);
        System.out.println("Post Order:"+list);

        System.out.println(binaryTree.sumOfAllNodes(root));
        System.out.println("sum at level:"+binaryTree.sumOfAllNodesAtLevelN(root,1));
        System.out.println("sum at level:"+binaryTree.sumOfAllNodesAtLevelK_Practice(root,1));

        root.left.left.left = new Node(3);
        System.out.println(binaryTree.maxLevel(root));
    }


    public Node create() {
        Node root = new Node(7);
        root.left = new Node(5);
        root.right = new Node(9);

        root.left.left = new Node(4);
        root.left.right = new Node(6);

        root.right.left = new Node(8);
        root.right.right = new Node(11);

        return root;
    }

    public int sumOfAllNodes(Node node) {
        return node==null ? 0 : sumOfAllNodes(node.left) + node.value + sumOfAllNodes(node.right);
    }


    public int sumOfAllNodesAtLevelK_Practice(Node node, int n) {

        if(node == null || n < 0)
            return 0;

        if(n==0) {
            return node.value;
        }
        return sumOfAllNodesAtLevelK_Practice(node.left, n-1) +
                sumOfAllNodesAtLevelK_Practice(node.right, n-1);
    }

    public int sumOfAllNodesAtLevelN(Node node, int n) {

        if(node == null)
            return 0;

        if(n==0)
            return node.value;

        return sumOfAllNodesAtLevelN(node.left, n-1) + sumOfAllNodesAtLevelN(node.right, n-1);
    }

    public  int maxLevel(Node node) {

        if(node == null)
            return 0;
        return 1 + Math.max(maxLevel(node.left), maxLevel(node.right));
    }

    public void inOrder(Node node, List<Integer> values) {
        if(node == null) {
            return;
        }
        inOrder(node.left, values);
        values.add(node.value);
        inOrder(node.right, values);
    }

    public void preOrder(Node node, List<Integer> values) {
        if(node == null) {
            return;
        }

        values.add(node.value);
        inOrder(node.left, values);
        inOrder(node.right, values);
    }

    public void postOrder(Node node, List<Integer> values) {
        if(node == null) {
            return;
        }
        inOrder(node.left, values);
        inOrder(node.right, values);
        values.add(node.value);
    }
}
