package ds.algos.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }
    public static String reverseVowels(String s) {

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');

        char chars[] = s.toCharArray();
        int begin = 0;
        int end = chars.length - 1;

        while (begin < end) {
            while (begin < end && !set.contains(chars[begin])) {
                begin++;
            }
            while (begin < end && !set.contains(chars[end])) {
                end--;
            }
            char temp = chars[begin];
            chars[begin++] = chars[end];
            chars[end--] = temp;
        }
        return new String(chars);
    }
}
