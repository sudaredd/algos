package ds.algos.amazon;

public class DecodeChars {

     /**
     * a3b2c1->aaabbc
     *
     * @param encodedStr
     * @return
     */
    public String decodeChar(String encodedStr) {
        char val = encodedStr.charAt(0);
        int pos = 1;
        StringBuilder decode = new StringBuilder();
        while (pos < encodedStr.length()) {
            if (Character.isDigit(encodedStr.charAt(pos))) {
                int num = 0;
                while (pos < encodedStr.length() && Character.isDigit(encodedStr.charAt(pos))) {
                    num = num * 10 + encodedStr.charAt(pos) - '0';
                    pos++;
                }
                fill(val, num, decode);
                if(pos < encodedStr.length())
                    val = encodedStr.charAt(pos++);

            }
        }
        return decode.toString();
    }

    private void fill(char val, int num, StringBuilder decode) {
        for (int i = 0; i < num; i++) {
            decode.append(val);
        }
    }
}
