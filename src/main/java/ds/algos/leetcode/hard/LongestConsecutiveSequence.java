package ds.algos.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * // Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * // For example,
 * // Given [100, 4, 200, 1, 3, 2],
 * // The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 2, 3, 4}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;

            while (set.contains(left)) set.remove(left--);
            while (set.contains(right)) set.remove(right++);

            max = Math.max(max, right - left - 1);
        }
        return max;
    }

}
