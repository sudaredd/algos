package ds.algos.bbg_practice;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println("================================");
        System.out.println(lengthOfLongestSubstringWithWhile("abcabcbb"));
        System.out.println(lengthOfLongestSubstringWithWhile("bbbbb"));
        System.out.println(lengthOfLongestSubstringWithWhile("pwwkew"));
    }

    private static int lengthOfLongestSubstringWithWhile(String str) {

        int begin = 0;
        int moving = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while (moving < str.length()) {
            char c = str.charAt(moving);
            if(!set.contains(c)) {
                set.add(c);
                moving++;
            } else {
                set.remove(str.charAt(begin));
                begin++;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    private static int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int begin = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                if (c == str.charAt(begin)) {
                    begin++;
                    continue;
                }
                while (c != str.charAt(begin)) {
                    set.remove(str.charAt(begin++));
                }

            }
            max = Math.max(max, set.size());
        }
        return max;

    }
}
