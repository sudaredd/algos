package ds.algos.practice;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Description: Given a String s, a sub-string is defined as a non-empty string that can be obtained by applying following operation
 * <p>
 * Remove zero or 1 character from left side of s
 * Remove zero or 1 character from right side of s
 * Remove zero or 1 character from left & right side of s
 * Find how many distinct sub-string possible.
 * Characters in string are [a-z]
 * String length can be up to 10^5
 */
public class SubstringCaluculator {

    public static void main(String[] args) {
        System.out.println(substringCalculator("abcde"));
    }
    static int substringCalculator(String s) {
        Set<String> set = new LinkedHashSet<>();
        substringCalculator(s, set);
        System.out.println(set);
        return set.size();
    }

    private static void substringCalculator(String s, Set<String> set) {

        if (s.isEmpty()) {
            return;
        }
        if(!set.add(s)) {
            return;
        }
        substringCalculator(s.substring(1, s.length()), set);
        substringCalculator(s.substring(0, s.length()-1), set);
        if(s.length() > 1)
        substringCalculator(s.substring(1, s.length()-1), set);
    }
}
