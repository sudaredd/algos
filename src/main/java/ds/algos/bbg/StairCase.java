package ds.algos.bbg;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StairCase {

    public static void main(String[] args) {

        System.out.println(5 + " " + climbStair(4));
        System.out.println(8 + " " + climbStair(5));
        System.out.println(13 + " " + climbStair(6));
        System.out.println("less mem");
        System.out.println(5 + " " + climbStair_lessMem(4));
        System.out.println(8 + " " + climbStair_lessMem(5));
        System.out.println(13 + " " + climbStair_lessMem(6));


        System.out.println("6 " + minPaidStairCase(3, new int[]{0, 2, 3, 4}));

        List<Integer> minCost = minPaidStairCase_withPath(8, new int[]{0, 3, 2, 4, 6, 1, 1, 5, 3});

        System.out.println(Arrays.asList(0, 2, 3, 5, 6, 8) + ":" + minCost);
    }

    public static List<Integer> minPaidStairCase_withPath(int n, int cost[]) {

        LinkedList<Integer> path = new LinkedList<>();

        int dp[] = new int[n + 1];
        int dpPath[] = new int[n + 1];

        dp[0] = 0;
        dp[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            dpPath[i] = dp[i - 1] < dp[i - 2] ? i - 1 : i - 2;
        }

        for (int i = n; i >= 0; i = dpPath[i]) {
            path.addFirst(i);
            if (i == 0)
                break;
        }
        return path;
    }

    public static int minPaidStairCase(int n, int cost[]) {

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return dp[n];
    }


    public static int climbStair(int stairs) {

        int[] dp = new int[stairs + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= stairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[stairs];
    }

    public static int climbStair_lessMem(int stairs) {

        int first = 1;
        int second = 1;
        int total = 0;
        for (int i = 2; i <= stairs; i++) {
            total = first + second;
            first = second;
            second = total;
        }
        return total;
    }

}
