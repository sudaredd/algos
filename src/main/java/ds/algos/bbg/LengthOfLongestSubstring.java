package ds.algos.bbg;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println("==============lengthOfLongestSubstring_practice===================");
        System.out.println(lengthOfLongestSubstring_practice("abcabcbb"));
        System.out.println(lengthOfLongestSubstring_practice("bbbbb"));
        System.out.println(lengthOfLongestSubstring_practice("pwwkew"));   
        
        System.out.println("=============lengthOfLongestSubstring_2====================");
        System.out.println(lengthOfLongestSubstring_2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring_2("bbbbb"));
        System.out.println(lengthOfLongestSubstring_2("pwwkew"));
    }
    public static int lengthOfLongestSubstring_2(String s) {
        Set<Character> set = new LinkedHashSet<>();
        int begin = 0;
        int moving = 0;
        int max = 0;
        
        Set<Character> maxSet = null;
        
        while (moving < s.length()) {
            char c = s.charAt(moving);
            if(!set.contains(c)) {
                set.add(c);
                max = Math.max(max, set.size());
                if(maxSet == null  || maxSet.size() < set.size()) {
                    maxSet = new LinkedHashSet<>(set);
                }
                moving++;
            } else {
                set.remove(s.charAt(begin));
                begin++;
            }
        }
        System.out.println(maxSet);
        return max;
        
    }
    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int begin = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if (!set.contains(val)) {
                set.add(val);
            } else {
                while (begin < i) {
                    if (s.charAt(begin) == val) {
                        begin++;
                        break;
                    } else if (s.charAt(begin) != val) {
                        set.remove(s.charAt(begin++));
                    }
                }
            }
            max = Math.max(set.size(), max);
        }

        return max;
    }

    public static int lengthOfLongestSubstring_practice(String s) {
        int longest = 0;
        int start = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if (!set.contains(val)) {
                set.add(val);
            } else {
                while (start < i) {
                    if (s.charAt(start) == val) {
                        start++;
                        break;
                    } else {
                        set.remove(s.charAt(start++));
                    }
                }
            }
            longest = Math.max(longest, set.size());
        }

        return longest;
    }

}
