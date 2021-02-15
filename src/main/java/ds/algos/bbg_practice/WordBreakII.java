package ds.algos.bbg_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * * s = "catsanddog"
 * * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * * Output:
 * * [
 * * "cats and dog",
 * * "cat sand dog"
 * * ]
 * * s = "pineapplepenapple"
 * * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * * Output:
 * * [
 * * "pine apple pen apple",
 * * "pineapple pen apple",
 * * "pine applepen apple"
 * * ]
 */
public class WordBreakII {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(wordBreakWithList("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));

    }

    private static List<String> wordBreak(String str, List<String> words) {
        List<String> l = new ArrayList<>();

        if (str == null || str.isEmpty()) {
            l.add("");
            return l;
        }
        for (String word : words) {
            if (str.startsWith(word)) {
                List<String> res = wordBreak(str.substring(word.length()), words);
                for (String r : res) {
                    l.add(new StringBuilder(word).append(" " + r.trim()).toString());
                }
            }
        }
        return l;
    }

    private static List<List<String>> wordBreakWithList(String str, List<String> dictionary) {

        List<List<String>> words = new LinkedList<>();
        if (str == null || str.isEmpty()) {
            List<String> l = new ArrayList<>();
            words.add(new LinkedList<>());
            return words;
        }
        for (String dict : dictionary) {
            if (str.startsWith(dict)) {
                List<List<String>> res = wordBreakWithList(str.substring(dict.length()), dictionary);
                for(List list: res) {
                    list.add(0, dict);
                    words.add(new ArrayList(list));
                }
            }
        }
        return words;
    }
}
