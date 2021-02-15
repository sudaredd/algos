package ds.algos.dp;

import java.util.HashMap;
import java.util.Map;

public class GridTravelor {

    public static void main(String[] args) {
        System.out.println(new GridTravelor().gridTravelor(2, 3));
        System.out.println(new GridTravelor().gridTravelor(5, 5));
        System.out.println(new GridTravelor().gridTravelorWithMemorization(2, 3, new HashMap<>()));
        System.out.println(new GridTravelor().gridTravelorWithMemorization(18, 18, new HashMap<>()));
        System.out.println("------------------------");
        System.out.println(new GridTravelor().gridTravelorBottomUp(2, 3));
        System.out.println(new GridTravelor().gridTravelorBottomUp(18, 18));
        System.out.println(new GridTravelor().gridTravelorBottomUp(5, 5));
    }

    private long gridTravelor(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        return gridTravelor(m - 1, n) + gridTravelor(m, n - 1);
    }

    private long gridTravelorBottomUp(int m, int n) {

        long dp[][] = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0) {
                    continue;
                }
                dp[i][j] = i>0 && j>0 ? dp[i-1][j] + dp[i][j-1] : i>0? dp[i-1][j] : dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

    }

    private long gridTravelorWithMemorization(int m, int n, Map<String, Long> map) {

        String key = m + "_" + n;
        if (map.containsKey(key))
            return map.get(key);

        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }

        long res = gridTravelorWithMemorization(m - 1, n, map) + gridTravelorWithMemorization(m, n - 1, map);
        map.put(key, res);
        return res;
    }
}
