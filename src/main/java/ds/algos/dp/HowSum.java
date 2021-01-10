package ds.algos.dp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        System.out.println(new HowSum().howSum(7, new int[]{2, 3})); //[3,2,2]
        System.out.println(new HowSum().howSum(10, new int[]{2, 3})); //[2,2,2,2,2]
        System.out.println(new HowSum().howSum(7, new int[]{5, 3, 4, 7})); //[4,3] or [7]
        System.out.println(new HowSum().howSum(7, new int[]{2, 4})); //null
        System.out.println(new HowSum().howSum(8, new int[]{2, 3, 5})); //[2,2,2,2]]
        LocalDateTime now = LocalDateTime.now();
        System.out.println(new HowSum().howSum(300, new int[]{7, 14})); //null
        Duration duration = Duration.between(now, LocalDateTime.now());
        System.out.println("total time::" + duration.getSeconds());
        System.out.println("-----------------With memorization-------------------");
        System.out.println(new HowSum().howSumMemorization(8, new int[]{2, 3, 5}, new HashMap<>())); //[2,2,2,2]]
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(new HowSum().howSumMemorization(300, new int[]{7, 14}, new HashMap<>())); //null
        Duration duration1 = Duration.between(now1, LocalDateTime.now());
        System.out.println("total time::" + duration1.getSeconds());
    }

    public List<Integer> howSum(int targetSum, int[] nums) {
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        for (int num : nums) {
            int reminder = targetSum - num;
            List<Integer> list = howSum(reminder, nums);
            if (list != null) {
                list.add(num);
                return list;
            }
        }
        return null;
    }
    
    public List<Integer> howSumMemorization(int targetSum, int[] nums, Map<Integer, List<Integer>> memo) {
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        if(memo.containsKey(targetSum))
            return memo.get(targetSum);
        for (int num : nums) {
            int reminder = targetSum - num;
            List<Integer> list = howSumMemorization(reminder, nums, memo);
            memo.put(targetSum, list);
            if (list != null) {
                list.add(num);
                return list;
            }
        }
        return null;
    }
}
