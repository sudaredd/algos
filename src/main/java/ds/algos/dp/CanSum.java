package ds.algos.dp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        System.out.println(new CanSum().canSum(7, new int[]{2, 3})); //true
        System.out.println(new CanSum().canSum(10, new int[]{2, 3})); //true
        System.out.println(new CanSum().canSum(7, new int[]{5, 3, 4, 7})); //true
        System.out.println(new CanSum().canSum(7, new int[]{2, 4})); //false
        System.out.println(new CanSum().canSum(8, new int[]{2, 3, 5})); //true     

        System.out.println("canSumP true::" + new CanSum().canSumP(5, new int[]{2, 3})); //false
        System.out.println("canSumP false::" + new CanSum().canSumP(7, new int[]{2, 4})); //false
        System.out.println("canSumP true::" + new CanSum().canSumP(8, new int[]{2, 3, 5})); //true


        LocalDateTime now = LocalDateTime.now();
        System.out.println(new CanSum().canSum(300, new int[]{7, 14})); //false
        Duration duration = Duration.between(now, LocalDateTime.now());
        System.out.println("total time::" + duration.getSeconds());

        System.out.println(new CanSum().canSumMemorization(7, new int[]{2, 3}, new HashMap<>())); //true
        System.out.println(new CanSum().canSumMemorization(300, new int[]{7, 14}, new HashMap<>())); //false

    }


    public boolean canSumP(int target, int[] array) {

        if (target == 0)
            return true;

        if (target < 0)
            return false;

        for (int val : array) {
            boolean flag = canSumP(target - val, array);
            if(flag)
                return true;
        }

        return false;

    }


    public boolean canSum(int targetSum, int[] nums) {
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;
        for (int num : nums) {
            boolean flag = canSum(targetSum - num, nums);
            if (flag)
                return true;
        }

        return false;
    }

    public boolean canSumMemorization(int targetSum, int[] nums, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;
        for (int num : nums) {
            boolean flag = canSumMemorization(targetSum - num, nums, memo);
            memo.put(targetSum, flag);
            if (flag)
                return true;
        }

        return false;
    }
}
