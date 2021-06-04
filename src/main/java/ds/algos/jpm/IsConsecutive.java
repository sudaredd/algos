package ds.algos.jpm;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Input :  str = "1234"
 * Output : Yes
 *
 * Input :  str = "91012"
 * Output : No
 *
 * Input :  str = "99100"
 * Output : Yes
 */
public class IsConsecutive {

    public static void main(String[] args) {

        long t = 1618643223198l;
        Date date = new Date(1618643223198l);;
        Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        System.out.println("dt:::"+format.format(date));

        System.out.println(UUID.randomUUID());
        System.out.println(isConsecutive("123456789101112"));
        System.out.println(isConsecutive("91012"));
        System.out.println(isConsecutive("99100"));
    }

    private static String isConsecutive(String val) {
        int length = val.length();

        for(int i=1; i<=length/2; i++) {

            String newString = val.substring(0, i);

            int nextVal = Integer.parseInt(newString);

            while (newString.length() < length) {
                if(!val.contains(newString)) {
                    break;
                }
                nextVal++;
                newString = newString + nextVal;

            }

            if(newString.equals(val)) {
                return "Yes";
            }
        }

        return "No";
    }
}
