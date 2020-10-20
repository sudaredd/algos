package ds.algos.leetcode.easy;

/**
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2
 *
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 */
public class ArrangeCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(1));
        System.out.println(arrangeCoins(2));
        System.out.println(arrangeCoins(3));
    }
    public static int arrangeCoins(int n) {
        int count = 1;
        while (n >= count) {
            n -= count++;
        }
        return count - 1;
    }
 }
