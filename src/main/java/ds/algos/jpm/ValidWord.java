package ds.algos.jpm;

import java.util.Objects;

public class ValidWord {
    public static void main(String[] args) {
        ValidWord validWord = new ValidWord();
        validWord.canDecompose("scream");
    }

    /**
     * scream
     * cream
     * ream
     * eam
     * am
     * a
     * @param str
     * @return true if a word can decompose until last character
     */
    public boolean canDecompose(String str) {
        if (Objects.isNull(str)) return false;
        while (true) {
            str = isValid(str);
            if (str == null || str.equals(""))
                return true;
            if ("NON_WORD".equals(str))
                return false;
        }
    }

    /**
     *
     * @param str
     * @return
     */
    public String isValid(String str) {
        for (int i = 0; i < str.length(); i++) {
            String stringToTest = str.substring(0, i) + str.substring(i + 1, str.length());
            boolean flag = isValidWord(stringToTest);
            if (flag)
                return stringToTest;
        }

        return "NON_WORD";
    }

    public boolean isValidWord(String str) {
        return true;
    }

}
