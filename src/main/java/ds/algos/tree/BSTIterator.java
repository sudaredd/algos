package ds.algos.tree;

import java.util.*;

public class BSTIterator {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator bstIterator = new BSTIterator(root);
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }

    }

    Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        iterator = iterativeInOrder(root).iterator();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return iterator.next();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return iterator.hasNext();
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
