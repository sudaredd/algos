package ds.algos.leetcode.medium;

import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        System.out.println("height is " + h);
        System.out.println("width is " + w);
        int res[][] = new int[h][w];
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (row == 0 && col == 0) {
                    res[row][col] = grid[row][col];
                } else {
                    res[row][col] = grid[row][col] + Math.min(row == 0 ? Integer.MAX_VALUE : res[row - 1][col],
                            col == 0 ? Integer.MAX_VALUE : res[row][col - 1]);
                }
            }
        }
        Arrays.stream(res).map(Arrays::toString).forEach(System.out::println);
        return res[h - 1][w - 1];
    }

    public int minPathSum_practice(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int dp[][] = new int[rowLength][colLength];
        Arrays.stream(grid).map(Arrays::toString).forEach(System.out::println);
        System.out.println();
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = grid[row][col];
                } else {
                    int top = row == 0 ? Integer.MAX_VALUE : dp[row - 1][col];
                    int prev = col == 0 ? Integer.MAX_VALUE : dp[row][col - 1];
                    dp[row][col] = grid[row][col] + Math.min(top, prev);
                }
            }
        }
        Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);

        return dp[rowLength - 1][colLength - 1];

    }

}
