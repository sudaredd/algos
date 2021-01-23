package ds.algos.leetcode.hard;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 */
public class MinimumWindowSubString {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {

        Set<Character> set = new LinkedHashSet<>();
        int left = 0;
        int right = t.length();
        for (int i = 0; i < right; i++) {
            set.add(s.charAt(i));
        }
        System.out.println(set);
        String res = null;
        while (left < right ) {
            boolean bool = true;
            for (char c : t.toCharArray()) {
                if (!set.contains(c)) {
                    bool = false;
                    break;
                }
            }
            if (bool) {
                if((res == null || (res.length() > set.size()))) {
                    res = set.stream().map(String::valueOf).collect(Collectors.joining());
                    System.out.println("res:::"+res);
                }
                set.remove(s.charAt(left++));
            } else {
                if(right == s.length()) break;
                if(set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left++));
                    continue;
                }
                set.add(s.charAt(right));
                right++;
            }
        }

        return res;
    }
}
