package ds.algos.bbg_practice;

public class MaxSubArray {
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaxSubArray().maxSubArray(arr));
    }

    private int maxSubArray(int[] arr) {
        int max = 0;
        int currentSum = 0;
        for(int i:arr) {
            currentSum +=i;

            if(currentSum > max) {
                max = currentSum;
            }
            if(currentSum <0) {
                currentSum = 0;
            }
        }
        return max;
    }
}
