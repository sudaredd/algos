package ds.algos.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(bestSum(8, new int[]{2,3,5}));
        System.out.println(bestSum(8, new int[]{1, 4, 5}));
        System.out.println("With memo");
        System.out.println(bestSum_Memorization(8, new int[]{1, 4, 5}, new HashMap<>()));
        System.out.println(bestSum_Memorization(100, new int[]{1, 2, 5, 25}, new HashMap<>()));
    }

    public static List<Integer> bestSum(int target, int nums[]) {

        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < 0) {
            return null;
        }

        List<Integer> shortestCombination = null;
        for (int num : nums) {
            List<Integer> reminderCombination = bestSum(target - num, nums);
            if (reminderCombination != null) {
                List<Integer> combination = new ArrayList<>(reminderCombination);
                combination.add(num);
                if(shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }

        return shortestCombination;
    }
    
    public static List<Integer> bestSum_Memorization(int target, int nums[], Map<Integer, List<Integer>> memo) {

        if(memo.containsKey(target))
            return memo.get(target);
        
        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < 0) {
            return null;
        }

        List<Integer> shortestCombination = null;
        for (int num : nums) {
            List<Integer> reminderCombination = bestSum_Memorization(target - num, nums, memo);
            if (reminderCombination != null) {
                List<Integer> combination = new ArrayList<>(reminderCombination);
                combination.add(num);
                if(shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }
        memo.put(target, shortestCombination);
        return shortestCombination;
    }
}
