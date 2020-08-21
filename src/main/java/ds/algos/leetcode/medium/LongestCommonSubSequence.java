package ds.algos.leetcode.medium;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
         System.out.println(new LongestCommonSubSequence().longtestCommonSubSequence("abce","acf"));
         System.out.println(new LongestCommonSubSequence().longtestCommonSubSequence("bsbininm","jmjkbkjkv"));
         System.out.println(new LongestCommonSubSequence().longestCommonSubsequence("bsbininlm","jmjkbkjkvl"));
    }

    public int longtestCommonSubSequence(String text1, String text2) {
        if(text1==null || text2==null)
            return 0;
        int fLength = text1.length();
        int sLength = text2.length();
        int csc[][] = new int[fLength+1][sLength+1];
        for(int i=1; i<=fLength; i++) {
            for(int j=1; j<=sLength; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    csc[i][j] = 1 + csc[i-1][j-1];
                } else {
                    csc[i][j] = Math.max(csc[i-1][j], csc[i][j-1]);

                }
            }
        }
        return csc[fLength][sLength];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        //text2 must be smaller string
        if (text1.length() < text2.length())
            return longestCommonSubsequence(text2, text1);

        int rows = text1.length() + 1;
        int cols = text2.length() + 1;
        int[] dp = new int[cols];

        for (int i = 1; i < rows; i++) {
            char a = text1.charAt(i-1);
            int diag = 0; //diagnol is always 0 when at a new row
            for (int j = 1; j < cols; j++) {
                int temp = dp[j]; //save curr val before modifying
                char b = text2.charAt(j-1);
                if (a == b)
                    dp[j] = diag + 1;
                else
                    dp[j] = Math.max(dp[j], dp[j-1]);
                diag = temp; //save as diag for next iteration
            }
        }

        return dp[cols-1];
    }
}
