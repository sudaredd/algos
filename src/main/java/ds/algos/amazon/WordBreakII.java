package ds.algos.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 */
public class WordBreakII {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(wordBreakMemo("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"), new HashMap<>()));
        System.out.println("----------------------");
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(wordBreakMemo("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"), new HashMap<>()));
    }

    private static List<String> wordBreak(String phrase, List<String> words) {
        List<String> results = new ArrayList<>();
        if (phrase == null || phrase.isBlank()) {
            results.add("");
            return results;
        }

        for (String word : words) {
            if (phrase.startsWith(word)) {
                List<String> subWords = wordBreak(phrase.substring(word.length()), words);
                for (String w : subWords) {
                    results.add(String.join(" ", word, w).trim());
                }
            }
        }
        return results;
    }

    private static List<String> wordBreakMemo(String phrase, List<String> words, Map<String, List<String>> memo) {
        if (memo.containsKey(phrase)) {
            return memo.get(phrase);
        }
        List<String> results = new ArrayList<>();
        if (phrase == null || phrase.isBlank()) {
            results.add("");
            return results;
        }

        for (String word : words) {
            if (phrase.startsWith(word)) {
                List<String> subWords = wordBreakMemo(phrase.substring(word.length()), words, memo);
                for (String w : subWords) {
                    results.add(String.join(" ", word, w).trim());
                }
            }
        }
        memo.put(phrase, results);
        return results;
    }
}
