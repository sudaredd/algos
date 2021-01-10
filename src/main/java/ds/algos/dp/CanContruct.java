package ds.algos.dp;

import java.util.HashMap;
import java.util.Map;

public class CanContruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstructMemoize("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(canConstructMemoize("eeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()));
    }

    private static boolean canConstruct(String str, String[] words) {
        if (str == null || str.equals("")) {
            return true;
        }
        for (String word : words) {
            if(str.startsWith(word)) {
                boolean flag = canConstruct(str.substring(word.length()), words);
                if(flag) {
                    return true;
                }
            }
        }

        return false;
    }
    
    private static boolean canConstructMemoize(String str, String[] words, Map<String, Boolean> memo) {
        if(memo.containsKey(str))
            return memo.get(str);
        if (str == null || str.equals("")) {
            return true;
        }
        for (String word : words) {
            if(str.startsWith(word)) {
                String suffix = str.substring(word.length());
                boolean flag = canConstructMemoize(suffix, words, memo);
                if(flag) {
                    memo.put(str, flag);
                    return true;
                }
            }
        }
        memo.put(str, false);
        return false;
    }
}
