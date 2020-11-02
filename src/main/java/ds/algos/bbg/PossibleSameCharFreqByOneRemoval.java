package ds.algos.bbg;

/**
 * Input: str = “xyyz”
 * Output: Yes
 * We can remove character ’y’ from above
 * string to make the frequency of each
 * character same.
 */
public class PossibleSameCharFreqByOneRemoval {

    public static void main(String[] args) {
        System.out.println(possibleSameCharFreqByOneRemoval("xyyz"));
        System.out.println(possibleSameCharFreqByOneRemoval("xxxxyyyzzz"));
    }

    static boolean possibleSameCharFreqByOneRemoval(String str) {

        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        if (isAllSame(freq)) {
            return true;
        }

        for (char c = 'a'; c < 'z'; c++) {
            int pos = c - 'a';
            if (freq[pos] > 0) {
                freq[pos]--;

                if (isAllSame(freq)) {
                    return true;
                }
                freq[pos]++;
            }
        }
        return false;
    }

    private static boolean isAllSame(int[] freq) {

        int same = 0;

        for (int f : freq) {
            if (f > 0) {
                if (same == 0)
                    same = f;
                else if (same != f) {
                    return false;
                }
            }
        }
        return true;

    }

}
