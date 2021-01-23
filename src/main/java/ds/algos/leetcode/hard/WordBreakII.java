package ds.algos.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 */
public class WordBreakII {

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));

        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println(wordsBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(wordsBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
    }

    public static List<String> wordsBreak(String s, List<String> wordDict) {
        List<String> l = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            l.add("");
            return l;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> list = wordsBreak(s.substring(word.length()), wordDict);
                if (list != null) {
                    for(String str : list)
                        l.add(word + " "+ str.trim());
                }
            }
        }
        return l;
    }


    public static List<String> wordBreak(String s, List<String> wordDict) {

        return wordBreakHelper(s, wordDict, new HashMap<>());

    }

    private static List<String> wordBreakHelper(String s, List<String> wordDict, HashMap<String, List<String>> cache) {

        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> results = new ArrayList<>();
        if (s.isEmpty()) {
            results.add("");
            return results;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subWordStr = wordBreakHelper(s.substring(word.length()), wordDict, cache);
                for (String str : subWordStr) {
                    str = !str.isEmpty() ? " " + str : str;
                    results.add(word + str);
                }
            }
        }
        cache.put(s, results);

        return results;
    }
}
