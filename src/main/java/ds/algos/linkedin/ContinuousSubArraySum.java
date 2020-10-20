package ds.algos.linkedin;

import java.util.Arrays;

/**
 * Given unsorted array of non negative, find a continuous sub array which adds up to a given number
 * [1,2,3,7,5], 12=>(1,4)
 */
public class ContinuousSubArraySum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(continuousSubArray(new int[]{1,2,3,7,5}, 12)));
        System.out.println(Arrays.toString(continuousSubArray(new int[]{3,3, 3,1,5}, 4)));
    }

    public static int[] continuousSubArray(int []array, int sum) {
        int begin = 0;
        int currentSum = 0;
        for(int i=0; i<array.length; i++) {
            currentSum += array[i];

            if(currentSum == sum) {
                return new int[] {begin, i};
            }

            while (currentSum > sum && begin <= i) {

                currentSum = currentSum - array[begin++];
                if(currentSum == sum) {
                    return new int[] {begin, i};
                }
            }
        }
        return new int[]{};
    }
}
