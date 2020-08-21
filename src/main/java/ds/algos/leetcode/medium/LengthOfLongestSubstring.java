package ds.algos.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));

        System.out.println(l.lengthOfLongestSubstring_practice("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring_practice("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring_practice("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int begin = 0;
        int longest = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if (!set.contains(val)) {
                set.add(val);
            } else {
                while (begin < i) {
                    if (s.charAt(begin) == val) {
                        begin++;
                        break;
                    } else {
                        set.remove(s.charAt(begin++));
//                        begin++;
                    }
                }
            }
            longest = Math.max(longest, set.size());
        }
//        System.out.println(s.substring(begin));
        return longest;
    }

    public int lengthOfLongestSubstring_practice(String s) {
        int begin = 0;
        int longest = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if (!set.contains(val)) {
                set.add(val);
            } else {
                while (begin < i) {
                    if (val == s.charAt(begin)) {
                        begin++;
                        break;
                    } else {
                        set.remove(s.charAt(begin));
                        begin++;
                    }
                }
            }
            longest = Math.max(longest, set.size());
        }

        return longest;
    }

}
