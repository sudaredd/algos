package ds.algos.leetcode.hard;

public class MaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new MaximumPathSum().maxPathSum(root));

    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;

    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0, dfs(node.right));
        maxSum = Math.max(maxSum, leftSum + rightSum + node.val);
        return Math.max(leftSum, rightSum) + node.val;
    }
}
