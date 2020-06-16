package ds.algos.tree;

import java.util.*;

public class InOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
//        root.right.left = new TreeNode(9);
//        root.right.right = new TreeNode(20);

        new InOrder().printInOrder(root);
        List<Integer> list = new ArrayList<>();
        new InOrder().addInOrder(root, list);
        System.out.println("recursive:"+list);
        System.out.println("iterative:"+new InOrder().iterativeInOrder(root));
    }

    public void printInOrder(TreeNode node) {
        if (node == null)
            return;
        printInOrder(node.left);
        System.out.println(node.val + " ");
        printInOrder(node.right);
    }

    public void addInOrder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        addInOrder(node.left, list);
        list.add(node.val);
        addInOrder(node.right, list);
    }

    public List<Integer> iterativeInOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inorderList = new ArrayList<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            root = stack.pop();
            inorderList.add(root.val);
            root = root.right;
        }
        return inorderList;
    }
}
