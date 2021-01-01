package ds.algos;

public class CheckAllAlphabets {

    public static void main(String[] args) {
        System.out.println(checkAllAlphabets("qwertyuioplkjhgfdsAzxcvbnm"));
        System.out.println(checkAllAlphabets_1("qwertyuioplkjhgfdsAzxcvbnm"));
        System.out.println(checkAllAlphabets("123"));
        System.out.println(checkAllAlphabets("ejuxggfsts"));
        System.out.println(checkAllAlphabets("wyyga"));
    }

    public static boolean checkAllAlphabets(String str) {

        int[] ary = new int[26];

        for (char c : str.toCharArray()) {

            if(c >='A' && c<='Z') {
                ary[c - 'A']++;
            } else if (c >= 'a' && c <= 'z') {
                ary[c - 'a']++;
            }
        }

        for (int count : ary) {
            if (count == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkAllAlphabets_1(String str) {

        boolean[] ary = new boolean[26];

        int counter = 0;
        for (char c : str.toCharArray()) {

            if(c >='A' && c<='Z' && !ary[c - 'A']) {
                ary[c - 'A'] = true;
                counter++;
            } else if (c >= 'a' && c <= 'z'&& !ary[c - 'a']) {
                ary[c - 'a'] = true;
                counter++;
            }
        }

        return counter==26;
    }
}


