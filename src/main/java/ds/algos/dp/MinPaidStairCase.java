package ds.algos.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinPaidStairCase {

    /**
     * f(n) = cost[n] + min (dp[n-1], dp[n-2])
     *
     * @param cost
     * @return
     */
    public int minPaidStairCase(int n, int cost[]) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return dp[n];
    }

    public List<Integer> minPaidStairCasePath(int n, int[] cost) {
        int dp[] = new int[n + 1];
        int dpPath[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            dpPath[i] = dp[i - 1] < dp[i - 2] ? i - 1 : i - 2;
        }

        //loop through dppos to add all min path from n to 0
        List<Integer> minPath = new ArrayList<>();
        for (int pos = n; pos >= 0; pos = dpPath[pos]) {
            minPath.add(pos);
            if (pos == 0)
                break;
        }
        Collections.reverse(minPath);
        return minPath;
    }

}


