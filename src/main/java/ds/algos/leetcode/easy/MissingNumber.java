package ds.algos.leetcode.easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++) {
            xor ^=i;
            xor^=nums[i];
        }
        xor ^=nums.length;
        return xor;
    }
}
