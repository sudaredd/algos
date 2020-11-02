package ds.algos.leetcode.easy;

import java.util.*;

/**
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 */
public class MostCommonWord {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(new MostCommonWord().mostCommonWord(paragraph, banned));
        System.out.println(new MostCommonWord().mostCommonWord_l(paragraph, banned));
    }

    public String mostCommonWord_l(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for(String word : banned) if(map.containsKey(word)) map.remove(word);
        String res = null;
        for(String word : map.keySet())
            if(res == null || map.get(word) > map.get(res))
                res = word;
        return res;
    }



    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> map = new LinkedHashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        for (String str : paragraph.toLowerCase().split("[ !?',;.]+")) {
            if (!set.contains(str))
                map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int count = 0;
        String val = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                val = entry.getKey();
            }
        }
        return val;

    }

}
