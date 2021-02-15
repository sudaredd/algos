package ds.algos.bbg_practice;

import java.util.Arrays;

/**
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeros {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeros(new int[]{0, 1, 0, 3, 12})));
    }

    private static int[] moveZeros(int[] nums) {
       int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[begin++] = nums[i];
            }
        }
        for(int j=begin; j<nums.length; j++) {
            nums[j] = 0;
        }
        return nums;
    }
}
