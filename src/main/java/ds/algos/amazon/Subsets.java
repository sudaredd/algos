package ds.algos.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}));
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        generateSubsets(0, nums, list, new ArrayList<>());
        return list;
    }

    private void generateSubsets(int start, int[] nums, List<List<Integer>> list, List<Integer> tempList) {
        list.add(new ArrayList(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            generateSubsets(i + 1, nums, list, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

}
