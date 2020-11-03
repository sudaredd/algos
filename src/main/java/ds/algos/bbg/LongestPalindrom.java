package ds.algos.bbg;

/**
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 * <p>
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 * <p>
 * Input: s = "ac"
 * Output: "a"
 */
public class LongestPalindrom {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ac"));

        System.out.println("=========================");
        System.out.println(longestPalindrome_practice("babad"));
        System.out.println(longestPalindrome_practice("cbbd"));
        System.out.println(longestPalindrome_practice("ac"));
    }

    public static String longestPalindrome(String s) {
        int left=0; int right = 0;

        for(int i=0; i<s.length(); i++) {
            int length1 = findMiddle(s, i, i);
            int length2 = findMiddle(s, i, i+1);

            int maxLength = Math.max(length1, length2);

            if(maxLength > right-left+1) {
                left = i - ((maxLength-1))/2;
                right = i + (maxLength)/2;
            }
        }
        return s.substring(left, right+1);


    }

    private static int findMiddle(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right - left -1;
    }




    public static String longestPalindrome_practice(String s) {
        int left = 0; int right =0;

        for(int i=0; i<s.length(); i++) {

            int fLength = findMiddle_prictice(s, i, i);
            int sLength = findMiddle_prictice(s, i, i+1);

            int length= Math.max(fLength, sLength);

            if(length > right-left+1) {
                left = i-(length-1)/2;
                right = i + (length)/2;
            }

        }
        return s.substring(left, right+1);
    }

    private static int findMiddle_prictice(String s, int left, int right) {
        while (left>=0 && right <=s.length()-1 && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right - left -1;
    }


}
