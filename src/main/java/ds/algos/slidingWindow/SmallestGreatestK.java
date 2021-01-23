package ds.algos.slidingWindow;

/**
 * Find smallest subarray length where sum is greater than or equal to k
 */
public class SmallestGreatestK {
    public static void main(String[] args) {
        System.out.println(smallestSubAryWithSumGtEqK(new int[]{2, 4, 2, 5, 1}, 7));
    }

    static int smallestSubAryWithSumGtEqK(int array[], int k) {
        int currentSum = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];

            while (currentSum >= k) {
                min = Math.min(min, i - start + 1);
                currentSum = currentSum - array[start];
                start++;
            }
        }
        return min;
    }
}
