package ds.algos.dp;

/**
 * Each time we can climb 1 or 2 steps.
 * find distinct ways to climb to the top
 */
public class ClimbStair {

    public int climbStair(int stairs) {
        int dp[] = new int[stairs + 1];

        dp[0] = 1;

        dp[1] = 1;

        for (int i = 2; i <= stairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[stairs];
    }

    public int climbStairWithLessMomory(int stairs) {

        int first = 1;

        int second = 1;

        int distinctWays = 1;

        for (int i = 2; i <= stairs; i++) {
            distinctWays = second + first;
            first = second;
            second = distinctWays;
        }
        return distinctWays;
    }
}
