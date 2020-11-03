package ds.algos.bbg;

public class UniquePaths {

    public static void main(String[] args) {

        int result = new UniquePaths().uniquePaths(3, 4);

        System.out.println("number of unique paths:" + result);

        int matrx[][] = new int[][] {
                {1, 3, 1, 1, 2},
                {2, 1, 1, 1, 1},
                {5, 4, 4, 2, 0}
        };

        UniquePaths uniquePaths = new UniquePaths();
        result = uniquePaths.maxProfitPaths(matrx);
        System.out.println("profit is :" + result);
    }

    public int maxProfitPaths(int[][] matrx) {
        int dp[][] = new int[matrx.length][matrx[0].length];

        for (int i = 0; i < matrx.length; i++) {
            for (int j = 0; j < matrx[i].length; j++) {
                int weight = matrx[i][j];

                if (i == 0 && j == 0) {
                    dp[i][j] = weight;
                    continue;
                }

                int top = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
                dp[i][j] = weight + Math.min(top, left);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];
        dp[0][0] = 1;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row > 0 && col > 0) {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                } else if (row > 0) {
                    dp[row][col] = dp[row - 1][col];
                } else if (col > 0) {
                    dp[row][col] = dp[row][col - 1];
                }
            }
        }
        return dp[m - 1][n - 1];

    }
}
