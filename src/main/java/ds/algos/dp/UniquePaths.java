package ds.algos.dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UniquePaths {

    /**
     * f (row, col) = f(row-1,col) + f(row, col-1)
     *
     * @param rows
     * @param columns
     * @return
     */
    public int uniquePaths(int rows, int columns) {

        int dp[][] = new int[rows][columns];
        dp[0][0] = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (row > 0 && col > 0) {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                } else if (row > 0) {
                    dp[row][col] = dp[row - 1][col];
                } else if (col > 0) {
                    dp[row][col] = dp[row][col - 1];
                }
            }
        }
        return dp[rows - 1][columns - 1];
    }

    /**
     * f (row, col) = f(row-1,col) + f(row, col-1) only when obstacleMatrix(row,col) != 1
     *
     * @param obstacleMatrix
     * @param rows
     * @param columns
     * @return
     */
    public int uniquePathsWithObstacles(int obstacleMatrix[][], int rows, int columns) {

        int dp[][] = new int[rows][columns];
        dp[0][0] = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (obstacleMatrix[row][col] == 1) {
                    dp[row][col] = 0;
                    continue;
                }

                if (row > 0 && col > 0) {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                } else if (row > 0) {
                    dp[row][col] = dp[row - 1][col];
                } else if (col > 0) {
                    dp[row][col] = dp[row][col - 1];
                }
            }
        }
        return dp[rows - 1][columns - 1];
    }

    /**
     * f(i)(j) = Max(f(i-1,j) , f(i, j-1) + matrix(i,j)
     *
     * @param matrx
     * @return
     */
    public int maxProfitPaths(int[][] matrx) {

        int rows = matrx.length;
        int columns = matrx[0].length;

        int dp[][] = new int[rows][columns];
        dp[0][0] = matrx[0][0];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int price = matrx[row][col];
                if (row > 0 && col > 0) {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + price;
                } else if (row > 0) {
                    dp[row][col] = dp[row - 1][col] + price;
                } else if (col > 0) {
                    dp[row][col] = dp[row][col - 1] + price;
                }
            }
        }
        print(dp);
        return dp[rows - 1][columns - 1];
    }

    private void print(int[][] dp) {
        List<int[]> list = new ArrayList<>();
        int row = dp.length - 1;
        int col = dp[row].length - 1;
        while (true) {
            list.add(new int[]{row, col});
            if (row == 0 && col == 0) {
                break;
            } else if (row == 0) {
                col = col - 1;
            } else if (col == 0) {
                row = row - 1;
            } else {
                if (dp[row - 1][col] > dp[row][col - 1]) {
                    row = row - 1;
                } else {
                    col = col - 1;
                }
            }
        }
        Collections.reverse(list);
        list.stream().
                map(Arrays::toString).
                forEach(System.out::println);
    }
}
