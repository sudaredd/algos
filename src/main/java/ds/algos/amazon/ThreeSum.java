package ds.algos.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-1, -1, 2}));
        System.out.println(threeSum_p1(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum_p1(new int[]{-1, -1, 2}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                if (target == nums[left] + nums[right]) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (right > 0 && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (target > nums[left] + nums[right]) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return result;
    }

    // -1 -1 2
    //-1,0,1,2,-1,-4
    //-1 -1 0 1 2 4
    public static List<List<Integer>> threeSum_p1(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (sum == nums[left] + nums[right]) {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum > nums[left] + nums[right]) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;

    }
}
