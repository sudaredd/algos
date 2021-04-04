package ds.algos.ice;


import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String val) {
        int begin = 0;
        int moving = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;

        while (moving < val.length()) {
            char c = val.charAt(moving);
            if(!set.contains(c)) {
                set.add(c);
                moving++;
            } else {
                set.remove(val.charAt(begin));
                begin++;
            }
            if(set.size() > max) {
                max = set.size();
            }
        }
        return max;
    }


}
