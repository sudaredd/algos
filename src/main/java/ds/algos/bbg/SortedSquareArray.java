package ds.algos.bbg;

import java.util.Arrays;

/**
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 */
public class SortedSquareArray {

    public static void main(String[] args) {
        int[] input = {-4, -1, 0, 3, 10};

        SortedSquareArray array = new SortedSquareArray();

        int[] output = array.sortedSquares(input);

        System.out.println(Arrays.toString(output));

        output = array.sortedSquares(new int[]{-7,-3,2,3,11});

        System.out.println(Arrays.toString(output));
    }

    public int[] sortedSquares(int[] input) {

        int output[] = new int[input.length];
        //compare with Math.abs first and last , fills from last one onwards

        int pos = output.length - 1;
        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            if (Math.abs(input[left]) > input[right]) {
                output[pos--] = input[left] * input[left];
                left++;
            } else {
                output[pos--] = input[right] * input[right];
                right--;
            }
        }

        return output;
    }
}
