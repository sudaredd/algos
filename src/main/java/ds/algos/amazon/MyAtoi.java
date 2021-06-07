package ds.algos.amazon;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 */
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("  -123"));
        System.out.println(myAtoi("  +32"));
        System.out.println(myAtoi("  32"));
        System.out.println(myAtoi("-0005880"));
    }
    public static int myAtoi(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        int prefix = 1;
        if (s.charAt(i) == '-') {
            prefix = -1;
            i++;
        } else if(s.charAt(i)=='+') {
            i++;
        }
        int res = 0;
        while (i<s.length()) {
            char c = s.charAt(i);
            if(!Character.isDigit(c)) {
                break;
            }
            int val = c-'0';
            res = res * 10 +val;
            i++;
        }

        return prefix * res;
    }
}
