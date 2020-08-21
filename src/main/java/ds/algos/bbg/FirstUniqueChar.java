package ds.algos.bbg;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 */
public class FirstUniqueChar {

    public int firstUniqueChar(String str) {

        int[] alphabets = new int[26];

        for (int i = 0; i < str.length(); i++) {

            alphabets[str.charAt(i) - 'a']++;

        }
        for (int i = 0; i < str.length(); i++) {

            if (alphabets[str.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;

    }
}
