package ds.algos.dp;

/**
 *      0	1	2	3	4	5	6	7	8	9	10	11	12	13
 *      T	F	F	F	F	F	F	F	F	F	F	F	F	F
 * 2	T	F	T	F	F	F	F	F	F	F	F	F	F	F
 * 3	T	F	T	T	F	T	F	F	F	F	F	F	F	F
 * 5	T	F	T	T	F	T	F	T	T	F	F	F	F	F
 * 7	T	F	T	T	F	T	F	T	T	T	T	F	T	F
 * 10	T	F	T	T	F	T	F	T	T	T	T	T	T	T
 */
public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(new SubsetSum().subsetSum(new int[]{2, 3, 5, 7, 10}, 18));
    }
    public boolean subsetSum(int items[], int sum) {
        boolean dp[][] = new boolean[items.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < items.length + 1; i++) {
            for (int j = 1; j <= sum; j++) {
                if (items[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - items[i - 1]];
                }
            }
        }
        return dp[items.length][sum];
    }
}
