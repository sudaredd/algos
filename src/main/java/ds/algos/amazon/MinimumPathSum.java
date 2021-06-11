package ds.algos.amazon;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 */
public class MinimumPathSum {

    public static void main(String[] args) {

        int grid[][] = new int[][]{{1, 3, 1}
                                  ,{1, 5, 1}
                                  ,{4, 2, 1}};

        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {

        int dp[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dp[i][j] = grid[i][j];
                if (i == 0 && j == 0) continue;
                dp[i][j] += i == 0 ? dp[i][j - 1] : j == 0 ? dp[i - 1][j] : Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
