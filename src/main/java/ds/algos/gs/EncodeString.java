package ds.algos.gs;

public class EncodeString {
    public static void main(String[] args) {
        System.out.println(encodeString("yyyybbbbdexxxxxxx"));//y4b4dex7
    }

    private static String encodeString(String str) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {
            int count = 1;
            sb.append(str.charAt(i));
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            if(count>1)
                sb.append(count);

        }
        return sb.toString();

    }
}
