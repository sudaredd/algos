package ds.algos.amazon;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class DepthestTreePath {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.right = new TreeNode(9);
        root.left.left = new TreeNode(7);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(13);

        int depth = depthestLevel(root);
        System.out.println(depth);
    }

    private static int depthestLevel(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        var level = new LinkedList<Integer>();
        var map = new LinkedHashMap<Integer, Integer>();
        int max = Integer.MIN_VALUE;
        queue.offer(root);
        level.add(1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer lev = level.poll();
            max = Math.max(lev, max);
            map.compute(lev, (k, v) -> v == null ? 1 : 1 + v);
            if (node.left != null) {
                queue.offer(node.left);
                level.offer(lev + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                level.offer(lev + 1);
            }
        }
        return map.values().stream().mapToInt(k -> k).max().orElse(0);
    }
}
