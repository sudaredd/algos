package ds.algos.bbg_practice;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 0 1 2 3 4 5 6 7 8 9 10 11
 * 0 0 0 0 0 0 0 0 0 0 0 0  0
 * 1 0 1 2 3 4 5 6 7 8 9 10 11
 * 2 0 1 1 2 2 3 3 4 4 5 5  6
 * 5 0 1 2 2 2 1 2 3 3 3 2  3
 * <p>
 * if(j > coins[i]))
 * memo[i][j] = 1 + memo[i][j-coins[j])
 * else
 * memo[i][j] = memo[i-1][j]
 */
public class MinCoins {
    public static void main(String[] args) {
        System.out.println(coinChangeTwoArray(new int[]{1, 2, 5}, 11));
        System.out.println(coinChangeTwoArray(new int[]{2}, 3));
    }

    private static int coinChangeTwoArray(int[] coins, int total) {

        int dp[][] = new int[coins.length + 1][total + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j >= coins[i - 1] && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                    dp[i][j] = 1 + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][total] == Integer.MAX_VALUE ? -1 : dp[coins.length][total];
    }
}
