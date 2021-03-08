package ds.algos.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAnagramsIndexes {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd" ,"abc"));
        System.out.println(findAnagrams("abab" ,"ab"));

        System.out.println(findAnagramsSlidingWindow("cbaebabacd" ,"abc"));
        System.out.println(findAnagramsSlidingWindow("abab" ,"ab"));
    }

    public static List<Integer> findAnagramsSlidingWindow(String s, String p) {
        List<Integer> l = new ArrayList<>();
        if(s==null || s.trim().length() == 0 || p==null || p.length()>s.length())
            return l;
        int sAry[] = new int[26];
        int pAry[] = new int[26];

        int left = 0;
        int right = 0;
        int window = p.length();

        while (right < window) {
            sAry[s.charAt(right)-'a']++;
            pAry[p.charAt(right)-'a']++;
            right++;
        }
        right--;
        while (right < s.length()) {
            if(isEqual(sAry, pAry)) {
                l.add(left);
            }
            sAry[s.charAt(left)-'a']--;
            left++;
            right++;
            if(right <s.length())
                sAry[s.charAt(right)-'a']++;
        }
        return l;
    }

    private static boolean isEqual(int[] sAry, int[] pAry) {
        for(int i=0; i<pAry.length; i++) {
            if(sAry[i] != pAry[i])
                return false;
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> l = new ArrayList<>();
        for(int i=0; i<s.length()-p.length()+1; i++) {
            boolean isAnagram = isAnagram(s, p, i);
            if(isAnagram)
                l.add(i);
        }
        return l;
    }

    private static boolean isAnagram(String s, String p, int i) {
        int []arry = new int[26];
        for(int pos=i; pos < i+p.length(); pos++) {
            arry[s.charAt(pos)-'a']++;
            arry[p.charAt(pos-i)-'a']--;
        }
        for(int val:arry) {
            if(val > 0)
                return false;
        }
        return true;
    }
}
