package ds.algos.leetcode.medium;

public class JumpGame {
    public boolean canJump(int []nums) {
        int jumpPosition = nums.length-1;
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] + i >=jumpPosition)
                jumpPosition = i;
        }
        return jumpPosition==0;
    }
}
