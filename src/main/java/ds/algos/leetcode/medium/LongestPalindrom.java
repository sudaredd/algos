package ds.algos.leetcode.medium;

public class LongestPalindrom {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrom().longestPalindrome("abbacaaca"));
        System.out.println(new LongestPalindrom().longestPalindrome("abad"));
    }
    public String longestPalindrome(String s) {
        if(s==null || s.length() <1)
            return "";

        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++) {
            int i1 = findMiddle(s, i, i);
            int i2 = findMiddle(s, i, i+1);

            int len = Math.max(i1, i2);
            if(len > end-start) {
                start = i - ((len-1)/2);
                end = i+ (len/2);
            }
        }
        return s.substring(start, end+1);
    }

    private int findMiddle(String s, int left, int right) {
        if(left > right)
            return 0;
        while (left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;

        }
        return right - left -1;
    }

}
