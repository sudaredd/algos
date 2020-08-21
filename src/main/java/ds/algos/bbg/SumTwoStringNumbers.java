package ds.algos.bbg;

import static ds.algos.bbg.StringToInteger.stringToInteger;

public class SumTwoStringNumbers {

    public static int sum2StringNums(String one, String two) {

        return stringToInteger(one) + stringToInteger(two);
    }

    public static String sumTwoStrings(String first, String second) {

        int left = first.length() - 1;
        int right = second.length() - 1;

        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (left >= 0 || right >= 0) {

            int one = left >= 0 ? first.charAt(left--) - '0' : 0;

            int two = right >= 0 ? second.charAt(right--) - '0' : 0;

            int sum = one + two + carry;

            if (sum > 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            result.insert(0, sum);
        }

        return result.toString();
    }
}
