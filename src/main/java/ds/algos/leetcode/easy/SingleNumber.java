package ds.algos.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.compute(num, (k,v)->v==null ? 1 : v + 1);
        }
        for (int n :  nums) {
            if(map.get(n)==1) return n;
        }
        return -1;
    }

    public int singleNumberXor(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++) {
            xor ^=nums[i];
        }
        return xor;
    }
}
