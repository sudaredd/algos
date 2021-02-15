package ds.algos.bbg_practice;


public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bababd"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ac"));
    }

    private static String longestPalindrome(String s) {

        int left = 0;

        int right = 0;

        for (int i = 0; i < s.length(); i++) {

            int firstLength = findMiddle(s, i, i);

            int secondLength = findMiddle(s, i, i + 1);

            int max = Math.max(firstLength, secondLength);

            if (max > right - left + 1) {
                left = i - (max - 1) / 2;
                right = i + (max) / 2;
            }

        }
        System.out.println("Max length::" + (right - left + 1));

        return s.substring(left, right + 1);

    }

    private static int findMiddle(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;

    }


}
