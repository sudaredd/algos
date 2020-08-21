package ds.algos.bbg;

public class StringToInteger {
    public static int stringToInteger(String numStr) {
        int sum = 0;
        boolean negative = false;
        int pos = 0;

        if (numStr.charAt(0) == '-') {
            negative = true;
            pos = 1;
        }
        for (; pos < numStr.length(); pos++) {
            int val = numStr.charAt(pos) - '0';
            sum = sum * 10 + val;
        }
        return negative ? -sum : sum;
    }
}
