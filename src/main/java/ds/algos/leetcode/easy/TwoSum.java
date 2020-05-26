package ds.algos.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 */
public class TwoSum {
    /**
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey((target-nums[i])))
                return new int[] {map.get(target-nums[i]), i};
            else
                map.put(nums[i], i) ;
        }
        return null;
    }
}
