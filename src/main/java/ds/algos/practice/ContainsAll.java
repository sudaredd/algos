package ds.algos.practice;

/**
 * Check if a string has all the characters of another string
 * String one = "This is a test";
 * String two = "This is a simple test";
 * I want to check if two contains all the characters that are in one, and ignore the fact it has extra characters.
 */

public class ContainsAll {

    public static void main(String[] args) {
        System.out.println(isContanisAll("This is a test","This is a simple test"));
        System.out.println(isContanisAll("This is a test","This is simple test"));
    }
    public static boolean isContanisAll(String first, String second) {
        int[] counts = new int[26];

        for (char c1 : first.toCharArray()) {
            if (c1 >= 'a' && c1 <= 'z') {
                counts[c1 - 'a'] = -1;
            }
        }

        for (char c1 : second.toCharArray()) {
            if (c1 >= 'a' && c1 <= 'z') {
                counts[c1 - 'a'] = 1;
            }
        }
        for (int val : counts) {
            if (val == -1)
                return false;
        }
        return true;
    }
}
