package ds.algos.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(new BinaryTreeRightSideView().rightSideView(root));
        System.out.println(new BinaryTreeRightSideView().rightSideViewRecursive(root));

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if(root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                if (i == size - 1) {
                    lists.add(treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null)
                    queue.add(treeNode.right);
            }
        }
        return lists;
    }

    public List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if(root == null) {
            return lists;
        }
        rightSideViewRecursive(root, lists, 0);
        return lists;
    }

    private void rightSideViewRecursive(TreeNode root, List<Integer> lists, int level) {
        if(root == null)
            return;
        if(lists.size() == level)
            lists.add(root.val);
        rightSideViewRecursive(root.right, lists, level+1);
        rightSideViewRecursive(root.left, lists, level+1);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
