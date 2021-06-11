package ds.algos.amazon;

/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * Input: num = 9
 * Output: "IX"
 * Example 4:
 *
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * Constraints:
 *
 * 1 <= num <= 3999
 */
public class IntToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(1234));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
    public static String intToRoman(int num) {
        //1234
        String m[] = {"", "M","MM","MMM"};
        String C[] = {"", "C","CC","CCC","CD","D","DC","DCC","DCCCC","CM"};
        String X[] = {"", "X", "XX", "XXX","XL","L","LX","LXX","XXC","XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return m[num/1000] + C[num%1000/100] + X[num%100/10] + I[num%10];
    }
}
