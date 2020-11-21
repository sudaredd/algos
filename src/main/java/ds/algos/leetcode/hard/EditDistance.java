package ds.algos.leetcode.hard;

/**
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * <p>
 * h o r s e
 * 0 1 2 3 4 5
 * r 1 1 2 2 3 4
 * o 2 2 1 2 3 4
 * s 3 3 2 2 2 3
 * <p>
 * formula = if(word.charAt(i)==word.charAt(j) {
 * dp[i][j] = 0 + dp[i-1][j-1];
 * else dp[i][j] = 1 + min (dp[i-1][j], dp[i-1][j-1], dp[i][j-1];
 * }
 */

public class EditDistance {

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
        word1 = "intention";
        word2 = "execution";
        System.out.println(minDistance(word1, word2));

    }

    public static int minDistance(String word1, String word2) {

        char c1[] = word1.toCharArray();
        char c2[] = word2.toCharArray();

        int fLength = c1.length;
        int sLength = c2.length;

        int dp[][] = new int[fLength + 1][sLength + 1];

        for (int i = 0; i <= fLength; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= sLength; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= fLength; i++) {
            for (int j = 1; j <= sLength; j++) {
                if (c1[i - 1] == c2[j - 1])
                    dp[i][j] = 0 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]);

            }
        }
        return dp[fLength][sLength];
    }

    private static int min(int i, int i1, int i2) {
        return Math.min(Math.min(i, i1), i2);
    }
}
