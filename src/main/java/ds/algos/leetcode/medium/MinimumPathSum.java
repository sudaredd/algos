package ds.algos.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int dp[][] = new int[grid.length][grid[0].length];


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dp[i][j] = grid[i][j];
                if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                    String p = dp[i - 1][j] < dp[i][j-1] ? i-1 + "_" + (j) : i + "_" + (j-1);
                } else if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        return dp[dp.length - 1][dp[0].length - 1];

    }

}
