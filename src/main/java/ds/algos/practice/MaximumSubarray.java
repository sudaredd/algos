package ds.algos.practice;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2, -1}));
        System.out.println(maxSubArray(new int[]{2, 1}));
    }

    public static int maxSubArray(int input[]) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : input) {
            sum += val;
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
