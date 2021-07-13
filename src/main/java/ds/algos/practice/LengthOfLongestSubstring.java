package ds.algos.practice;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcab"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String str) {

        int begin = 0;
        int fast = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (fast < str.length()) {
            char current = str.charAt(fast);
            if (!set.contains(current)) {
                set.add(current);
                fast++;
            } else {
                set.remove(str.charAt(begin++));
            }

            max = Math.max(max, set.size());
        }
        return max;
    }
}
