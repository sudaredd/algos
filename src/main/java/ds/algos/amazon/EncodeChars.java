package ds.algos.amazon;

public class EncodeChars {
    public String encodeChars(String str) {
        if (str == null || str.length() == 0)
            return "";

        char[] chars = str.toCharArray();
        char previous = chars[0];
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == previous) {
                counter++;
            } else {
                sb.append(counter).append(previous);
                previous = chars[i];
                counter = 1;
            }
        }
        return sb.append(counter).append(previous).toString();

    }
}
