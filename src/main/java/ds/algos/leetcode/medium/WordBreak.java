package ds.algos.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxLength = 0;
        for(String w: wordDict) {
            set.add(w);
            maxLength = Math.max(maxLength, w.length());
        }
        int length = s.length();
        boolean dp[] = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if(i-j > maxLength)
                    continue;
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
