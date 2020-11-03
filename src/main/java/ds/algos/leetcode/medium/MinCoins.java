package ds.algos.leetcode.medium;

import java.util.Arrays;

public class MinCoins {

    public static void main(String[] args) {
        MinCoins minCoins = new MinCoins();
//        System.out.println(minCoins.coinChange(new int[] {1, 2, 5}, 11));
//        System.out.println(minCoins.coinChange(new int[] {2}, 3));
        System.out.println(minCoins.coinChangeTwoArray(new int[] {1, 2, 5}, 11));
        System.out.println(minCoins.coinChangeTwoArray(new int[] {2}, 3));
        System.out.println(minCoins.coinChangeTwoArray_practice(new int[] {1, 2, 5}, 11));
        System.out.println(minCoins.coinChangeTwoArray_practice(new int[] {2}, 3));
//        System.out.println(minCoins.coinChange(new int[] {1, 2, 5}, 6));
    }
    public int coinChangeTwoArray(int[] coins, int amount) {
        int total[][] = new int[coins.length+1][amount + 1];
        Arrays.fill(total[0], Integer.MAX_VALUE);
        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                if(coins[i-1] <= j && total[i][j-coins[i-1]] != Integer.MAX_VALUE) {
                    total[i][j] = Math.min(total[i-1][j], 1 + total[i][j-coins[i-1]]);
                } else
                    total[i][j] = total[i-1][j] ;
            }
        }
        return total[coins.length][amount]==Integer.MAX_VALUE ? -1 : total[coins.length][amount];
    }

    public int coinChangeTwoArray_practice(int[] coins, int amount) {

        int dp[][] = new int[coins.length+1][amount+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);

        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                if(coins[i-1] <= j && dp[i][j- coins[i-1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }

                }
            }
        return dp[coins.length][amount]==Integer.MAX_VALUE ? -1 : dp[coins.length][amount] ;
        }


        public int coinChange(int[] coins, int amount) {
         if (coins == null || coins.length == 0 || amount <= 0)
             return 0;
         int[] minNumber = new int[amount + 1];
         for (int i = 1; i <= amount; i++) {
             minNumber[i] = Integer.MAX_VALUE;
             for (int j = 0; j < coins.length; j++) {
                 if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE)
                     minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
             }
         }
         if (minNumber[amount] == Integer.MAX_VALUE)
             return -1;
         else
             return minNumber[amount];
    }
}
