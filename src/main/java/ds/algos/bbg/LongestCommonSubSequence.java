package ds.algos.bbg;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubSequence("abcde", "ace"));
        System.out.println(longestCommonSubSequence("abc", "abc"));
        System.out.println(longestCommonSubSequence("abc", "def"));
        System.out.println(longestCommonSubSequence("bsbininlm", "jmjkbkjkvl"));

    }

    private static int longestCommonSubSequence(String first, String second) {

        int dp[][] = new int[first.length() + 1][second.length() + 1];

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[first.length()][second.length()];
    }
}
