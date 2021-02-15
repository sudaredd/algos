package ds.algos.bbg_practice;

public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(firstUniqueChar("leetcode"));
        System.out.println(firstUniqueChar("loveleetcode"));
    }

    private static char firstUniqueChar(String str) {
        int [] chars = new int[26];
        for(char c : str.toCharArray()) {
            chars[c-'a']++;
        }
        for(char c : str.toCharArray()) {
            if(chars[c-'a']==1) {
                return c;
            }
        }

        return 0;
    }
}
