package ds.algos.leetcode.easy;

public class Rob {
    public int rob(int[] nums) {
        int rob = 0;
        int nonRob = 0;
        for(int i=0; i<nums.length; i++) {
            if(i%2==0) {
                rob = Math.max(rob + nums[i], nonRob);
            } else {
                nonRob = Math.max(nonRob+nums[i], rob);
            }
        }
        return Math.max(rob, nonRob);
    }
}
