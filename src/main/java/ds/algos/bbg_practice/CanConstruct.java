package ds.algos.bbg_practice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(LocalDateTime.now());
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
        System.out.println(LocalDateTime.now());
        System.out.println("---------------with memo");
        System.out.println(canConstructWithMemo("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(canConstructWithMemo("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(LocalDateTime.now());
        System.out.println(canConstructWithMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()));
        System.out.println(LocalDateTime.now());

    }

    private static boolean canConstruct(String str, String[] dict) {
        if(str == null || str.isEmpty()) {
            return true;
        }
        for(String word: dict) {
            if(str.startsWith(word)) {
                boolean flag = canConstruct(str.substring(word.length()), dict);
                if(flag)
                    return true;
            }
        }
        return false;

    }


    private static boolean canConstructWithMemo(String str, String[] dict, Map<String, Boolean> memo) {
        if(str == null || str.isEmpty()) {
            return true;
        }
        if(memo.containsKey(str)) {
            return memo.get(str);
        }
        for(String word: dict) {
            if(str.startsWith(word)) {
                boolean flag = canConstructWithMemo(str.substring(word.length()), dict, memo);
                if(flag) {
                    memo.put(str, true);
                    return true;
                }
            }
        }
        memo.put(str, false);
        return false;

    }
}
