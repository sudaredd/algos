package ds.algos.bbg;

import ds.algos.leetcode.hard.TreeNode;

import java.util.*;

/**
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BinaryTreeLevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);

        System.out.println(new BinaryTreeLevelOrder().levelOrder(root));
        System.out.println(new BinaryTreeLevelOrder().levelOrder_practice(root));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        queue.offer(root);
        levelQueue.add(0);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int level = levelQueue.poll();
            if (list.size() < level + 1) {
                list.add(new ArrayList<>());
            }

            list.get(level).add(current.getVal());
            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
                levelQueue.add(level + 1);
            }
            if (current.getRight() != null) {
                queue.offer(current.getRight());
                levelQueue.add(level + 1);
            }
        }

        return list;
    }

    public List<List<Integer>> levelOrder_practice(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelQ = new LinkedList<>();

        queue.add(root);
        levelQ.add(1);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            int level = levelQ.poll();

            if(levels.size() < level) {
                levels.add(new ArrayList<>());
            }
            levels.get(level-1).add(node.getVal());

            if(node.left != null) {
                queue.offer(node.left);
                levelQ.offer(level+1);
            }
            if(node.right != null) {
                queue.offer(node.right);
                levelQ.offer(level+1);
            }

        }

        return levels;
    }
}
