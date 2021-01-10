package ds.algos.dp;

import java.util.HashMap;

public class CountConstruct {
    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "ef", "def", "abcd"}));
        System.out.println(countConstructMemoize("eeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()));

    }

    private static int countConstructMemoize(String target, String[] words, HashMap<String, Integer> memo) {
        if(memo.containsKey(target))
            return memo.get(target);
        
        if(target.equals("")) {
            return 1;
        }
        int count = 0;
        for(String word : words) {
            if(target.startsWith(word)) {
                int temp = countConstructMemoize(target.substring(word.length()), words, memo);
                count = count + temp;
            }
        }
        memo.put(target, count);
        return count;
        
    }

    private static int countConstruct(String target, String[] words) {
        if (target.equals("")) {
            return 1;
        }
        int count = 0;
        for (String word : words) {
            if (target.startsWith(word)) {
                int temp = countConstruct(target.substring(word.length()), words);
                count += temp;
            }
        }

        return count;
    }
}
