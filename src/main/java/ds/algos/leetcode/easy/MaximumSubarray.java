package ds.algos.leetcode.easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int total = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            total = Math.max(total+nums[i], nums[i]);
            if(total > maxSoFar)
                maxSoFar = total;
        }
        return maxSoFar;
    }
}
