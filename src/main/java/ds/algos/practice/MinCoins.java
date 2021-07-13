package ds.algos.practice;

import java.util.Arrays;

/**
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * 0 1 2 3 4 5 6 7 8 9 10 11
 * 1 0 1 2 3 4 5 6 7 8 9 10 11
 * 2 0 1 0 2 2 3 3 4 4 5 5  6
 * 5 0 1 0 2 2 1 2 2 3 3 3  3
 * <p>
 * if(coins[i-1] <= amt) {
 * dp[i][j]= Math.min(dp[i-1][j], 1 + dp[i-1][j-coins[i-1]]
 * } else {
 * dp[i][j]= dp[i-1][j];
 * }
 */
public class MinCoins {

    public static void main(String[] args) {
        /*System.out.println(new MinCoins().coinChange(new int[]{1,2,5}, 11));
        System.out.println(new MinCoins().coinChange(new int[]{3}, 2));*/
        System.out.println(new MinCoins().coinChange(new int[]{5}, 5));
        System.out.println(new MinCoins().coinChange(new int[]{1}, 0));
        System.out.println(new MinCoins().coinChange(new int[]{1}, 1));
        System.out.println(new MinCoins().coinChange(new int[]{1}, 2));
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][amount]==Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }

}
