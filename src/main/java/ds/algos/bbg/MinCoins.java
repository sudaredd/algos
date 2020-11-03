package ds.algos.bbg;

import java.util.Arrays;

public class MinCoins {

    public static void main(String[] args) {
        System.out.println(coinChangeTwoArray(new int[] {1, 2, 5}, 11));
        System.out.println(coinChangeTwoArray(new int[] {1, 2, 5}, 10));
        System.out.println(coinChangeTwoArray(new int[] {1, 2, 5}, 8));
        System.out.println(coinChangeTwoArray(new int[] {2}, 3));
//        System.out.println(coinChangeOneArray(new int[] {2}, 3));
        System.out.println(coinChangeOneArray(new int[] {1, 2, 5}, 11));

    }
    public static int coinChangeTwoArray(int[] coins, int amount) {

        int dp[][] = new int[coins.length+1][amount+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);

        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                if(j >=coins[i-1] && dp[i][j-coins[i-1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount]==Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }

    public static int coinChangeOneArray(int[] coins, int amount) {

        int dp[] = new int[amount+1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE-1);

        for(int i=1; i<=amount; i++) {
            for(int coin : coins) {
                if(i >= coin)
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }


        return dp[amount];
    }

    }
