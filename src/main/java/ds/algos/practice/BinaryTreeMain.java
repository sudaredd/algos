package ds.algos.practice;

import java.util.ArrayList;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(10);
        binaryTree.insert(8);
        binaryTree.insert(12);
        binaryTree.insert(15);
        binaryTree.insert(11);
        System.out.println(binaryTree.root.toString());
/*        binaryTree.delete(binaryTree.root, 12);
        System.out.println(binaryTree.root.toString());*/
        ArrayList<Integer> vals = new ArrayList<>();
        binaryTree.inOrder(binaryTree.root, vals);
        System.out.println("In Order::" + vals);
        System.out.println("Sum at level3::" + binaryTree.sumAtKLevel(binaryTree.root, 3));
    }

}
