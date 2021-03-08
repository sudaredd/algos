package ds.algos.leetcode.medium;

public class AnagramPermutations {

    public static void main(String[] args) {
        permutation("ABC");
    }

    private static void permutation(String str) {
        permutation("", str);
        System.out.println("=====================");
    }

    private static void permutation(String prefix, String str) {
        if (str == "" || str.length() == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
        }
    }

}
