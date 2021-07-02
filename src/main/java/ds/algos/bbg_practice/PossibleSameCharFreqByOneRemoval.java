package ds.algos.bbg_practice;

public class PossibleSameCharFreqByOneRemoval {
    public static void main(String[] args) {
        System.out.println(possibleSameCharFreqByOneRemoval("xyz"));
        System.out.println(possibleSameCharFreqByOneRemoval("xxyyyzz"));
        System.out.println(possibleSameCharFreqByOneRemoval("xxxxyyyzzz"));
        System.out.println(possibleSameCharFreqByOneRemoval("xxxxyyyzzzz"));
    }

    private static boolean possibleSameCharFreqByOneRemoval(String str) {
        int freq[] = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        if (isAllSame(freq)) {
            return true;
        }
        for (int pos = 0; pos < freq.length; pos++) {
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

    private static boolean isAllSame(int[] counter) {
        int v = 0;
        for (int c : counter) {
            if (c != 0) {
                if (v == 0) {
                    v = c;
                } else if (c != v)
                    return false;
            }
        }
        return true;
    }
}
