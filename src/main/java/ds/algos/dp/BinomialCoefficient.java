package ds.algos.dp;

import java.util.Arrays;

public class BinomialCoefficient {

    public static void main(String[] args) {
        System.out.println(binomial_coefficient(6,6));
    }
    static long binomial_coefficient(int n,int m){
        int dp[][] = new int[n][m];

        for(int i=0; i<n;i++) {
            dp[i][0] = 1;
            dp[i][i]=1;
        }

        for(int i=2; i<n; i++) {
            for(int j=1; j<i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        for(int i=0; i<n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n-1][m-1];

    }
}
