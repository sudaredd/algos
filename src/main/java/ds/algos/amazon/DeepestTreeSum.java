package ds.algos.amazon;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class DeepestTreeSum {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        int depth = deepestTreeSum(root);
        System.out.println(depth);
        System.out.println(deepestLeavesSum(root));
    }

    public static int deepestLeavesSum(TreeNode root) {
        var queue = new LinkedList<TreeNode>();

        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }

    private static int deepestTreeSum(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        var level = new LinkedList<Integer>();
        var map = new LinkedHashMap<Integer, Integer>();
        queue.offer(root);
        level.add(1);
        int max = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer lev = level.poll();
            max = Math.max(max, lev);
            map.put(lev, map.getOrDefault(lev, 0) + node.val);
            if (node.left != null) {
                queue.offer(node.left);
                level.offer(lev + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                level.offer(lev + 1);
            }
        }
        return map.get(max);
    }
}
