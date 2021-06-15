package ds.algos.amazon;

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(binaryTreeLevelOrderTraversal(root));
        System.out.println(binaryTreeLevelOrderTraversal_P(root));
        System.out.println(binaryTreeLevelOrderRecursiveTraversal(root));
    }

    public static List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        var levelQueue = new LinkedList<Integer>();
        queue.add(root);
        levelQueue.add(1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = levelQueue.poll();

            if (result.size() < level) {
                result.add(new ArrayList<>());
            }
            result.get(level - 1).add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                levelQueue.add(level + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                levelQueue.add(level + 1);
            }
        }
        return result;
    }

    public static List<List<Integer>> binaryTreeLevelOrderTraversal_P(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        queue.add(root);
        levelQueue.add(1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = levelQueue.poll();
            if(levels.size() < level) {
                levels.add(new ArrayList<>());
            }
            levels.get(level-1).add(node.val);

            if(node.left != null) {
                queue.offer(node.left);
                levelQueue.offer(level+1);
            }
            if(node.right != null) {
                queue.offer(node.right);
                levelQueue.offer(level+1);
            }
        }

        return levels;
    }
    public static List<List<Integer>> binaryTreeLevelOrderRecursiveTraversal(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        binaryTreeLevelOrderRecursiveTraversal(root, 1, levels);
        return levels;
    }

    private static void binaryTreeLevelOrderRecursiveTraversal(TreeNode node, int level, List<List<Integer>> levels) {
        if(node == null) {
            return;
        }
        if(levels.size() < level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level-1).add(node.val);
        binaryTreeLevelOrderRecursiveTraversal(node.left, level+1, levels);
        binaryTreeLevelOrderRecursiveTraversal(node.right, level+1, levels);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
