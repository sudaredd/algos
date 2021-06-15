package ds.algos.amazon;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("aaakdks"));
    }
    public static String longestPalindrome(String s) {
        int left =0 ;
        int right =0 ;
        for(int i=0; i<s.length(); i++) {
            int first = findMiddle(s, i, i);
            int second = findMiddle(s, i, i+1);
            int max = Math.max(first, second);

            if(max > right-left) {
                left = i - (max-1)/2;
                right = i+ max/2;
            }
        }
        return s.substring(left, right+1);
    }

    private static int findMiddle(String s, int begin, int end) {
        while (begin >=0 && end <s.length() && s.charAt(begin)==s.charAt(end)) {
            begin--;
            end++;
        }
        return end - begin -1;
    }
}
