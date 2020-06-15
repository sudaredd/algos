package ds.algos.leetcode.easy;

public class Palindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int begin = 0;
        int end = s.length()-1;
        while (begin < end) {
            char beginChar = s.charAt(begin);
            char endChar = s.charAt(end);
            if(isNotAlphaNumeric(beginChar)) {
                begin++;
                continue;
            }
            if(isNotAlphaNumeric(endChar)) {
                end--;
                continue;
            }
            if(beginChar != endChar){
                return false;
            } else {
                begin++;
                end--;
            }
        }
        return true;
    }

    private boolean isNotAlphaNumeric(char beginChar) {
        return !Character.isAlphabetic(beginChar) && !Character.isDigit(beginChar);
    }
}
