package ds.algos.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("leetcode", Arrays.asList("lee", "code")));
        System.out.println(wordBreak("cars", Arrays.asList("car", "ca", "rs")));
        System.out.println("======================================");
        System.out.println(wordBreakMemoization("leetcode", Arrays.asList("leet", "code"), new HashMap<>()));
        System.out.println(wordBreakMemoization("leetcode", Arrays.asList("lee", "code"), new HashMap<>()));
        System.out.println(wordBreakMemoization("cars", Arrays.asList("car", "ca", "rs"), new HashMap<>()));
    }

    private static boolean wordBreak(String phrase, List<String> words) {
        if (phrase == null || phrase.isBlank()) {
            return true;
        }
        for (String word : words) {
            if (phrase.startsWith(word)) {
                boolean flag = wordBreak(phrase.substring(word.length()), words);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean wordBreakMemoization(String phrase, List<String> words, Map<String, Boolean> memo) {
        if (phrase == null || phrase.isBlank()) {
            return true;
        }
        if (memo.containsKey(phrase)) {
            return true;
        }
        for (String word : words) {
            if (phrase.startsWith(word)) {
                boolean flag = wordBreak(phrase.substring(word.length()), words);
                if (flag) {
                    memo.put(phrase, true);
                    return true;
                }
            }
        }
        memo.put(phrase, false);
        return false;
    }
}
