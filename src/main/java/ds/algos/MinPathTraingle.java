package ds.algos;

import java.util.Arrays;

public class MinPathTraingle {

    public static void main(String[] args) {
        int array[][] = {
                   {2}, 
                  {5, 3},
                 {6, 4, 7},
                {9, 5, 3, 1}
        };
        System.out.println(minPath(array));
    }
    
    public static int minPath(int[][] array) {

        int length =array[ (array.length-1)].length;
        int dp[] = new int[length];
        
        for(int i=0; i<length; i++) {
            dp[i] = array[length-1][i];
        }
        System.out.println(Arrays.toString(dp));

        for(int i=length-2; i >0; i--) {
            for(int j=0; j<array[i].length; j++) {
                dp[j] = array[i][j]+ Math.min(dp[j], dp[j+1]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }
}
