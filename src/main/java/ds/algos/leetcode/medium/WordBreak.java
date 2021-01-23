package ds.algos.leetcode.medium;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
//        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
//        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
//        System.out.println("-------------------------------------");
//        System.out.println(canWordBreak("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(canWordBreak("applepenapple", Arrays.asList("apple", "pen")));
//        System.out.println(canWordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(canWordBreak("cars", Arrays.asList("car","ca","rs")));

    }


    public static boolean canWordBreak(String str, List<String> words) {

        return canWordBreak(str, words, new HashMap<>());
    }

    private static boolean canWordBreak(String str, List<String> words, Map<String, Boolean> memo) {

        if (str == null || str.isEmpty()) {
            return true;
        }
        if(memo.containsKey(str)) {
            return memo.get(str);
        }
        for (String word : words) {
            if (str.startsWith(word)) {
                boolean bool = canWordBreak(str.substring(word.length()), words, memo);
                if(bool) {
                    memo.put(str, bool);
                    return bool;
                }
            }
        }
        memo.put(str, false);
        return false;
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxLength = 0;
        for (String w : wordDict) {
            set.add(w);
            maxLength = Math.max(maxLength, w.length());
        }
        int length = s.length();
        boolean dp[] = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (i - j > maxLength)
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
