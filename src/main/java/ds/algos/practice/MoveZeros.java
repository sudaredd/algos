package ds.algos.practice;

import java.util.Arrays;

/**
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 */
public class MoveZeros {

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        new MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[begin++] = nums[i];
        }
        for (; begin < nums.length; begin++) {
            nums[begin] = 0;
        }
    }
}
