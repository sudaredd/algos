package ds.algos.bbg;

public class MaxSubArray {

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaxSubArray().maxSubArray(arr));
    }

    public int maxSubArray(int[] ary) {
        int max = ary[0];

        int sum = 0;

        for (int i = 0; i < ary.length; i++) {
            sum = sum + ary[i];

            if (sum > max)
                max = sum;

            if (sum < 0)
                sum = 0;
        }

        return max;

    }
}
