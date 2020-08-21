package ds.algos.bbg;

/**
 * Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5
 * <p>
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * <p>
 * Example 2: Input: [7, 6, 4, 3, 1] Output: 0
 */
public class BestTimeBuySellStock {

    public int maxProfit(int[] arr) {
        int maxProfit = 0;
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxProfit = Math.max(maxProfit, arr[i] - min);
            if (min > arr[i]) {
                min = arr[i];
            }

        }

        return maxProfit;
    }
}
