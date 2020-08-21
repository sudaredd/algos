package ds.algos.leetcode.medium;

public class LongestPalindrom_Practice1 {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrom_Practice1().longestPalindrome("abbacaaca"));
        System.out.println(new LongestPalindrom_Practice1().longestPalindrome("abad"));
        System.out.println(new LongestPalindrom_Practice1().longestPalindrome("abbavgg"));
    }
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;

        for(int i=0; i<s.length(); i++) {
            int first = findMiddle(s, i, i);
            int second = findMiddle(s, i, i+1);

            int length = Math.max(first, second);
            if(length > right-left) {
                left = i - (length-1)/2;
                right = i + length/2;
            }
        }

        return s.substring(left, right+1);
    }

    private int findMiddle(String s, int left, int right) {

        while (left >= 0 && right <=s.length()-1 && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;

    }


}
