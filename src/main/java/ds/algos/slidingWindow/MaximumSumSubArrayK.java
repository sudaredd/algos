package ds.algos.slidingWindow;

public class MaximumSumSubArrayK {

    public static void main(String[] args) {
        int a[] = {2, 3, 4, 1, 5};
        System.out.println(maxSum(a, 3));

        int b[] = {2, 5, 4, 1, 5};
        System.out.println(maxSum(b, 3));
    }
    public static int maxSum(int []array, int k) {

        int first = 0;
        int maxSum = 0;
        int currentSum = 0;
        for(int i=0; i<array.length; i++) {
            currentSum +=array[i];
            if(i-first==k-1) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum = currentSum - array[first];
                first++;
            }
        }
        return maxSum;
    }
}
