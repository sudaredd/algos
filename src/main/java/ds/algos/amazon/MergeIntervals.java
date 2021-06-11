package ds.algos.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 4}, {4, 5}};
        int[][] merge = merge(a);
        for (int[] val : merge)
            System.out.println(Arrays.toString(val));
        System.out.println("---------------------");
        a = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] val : merge(a))
            System.out.println(Arrays.toString(val));
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int array[] = intervals[0];
        list.add(array);
        for (int i = 1; i < intervals.length; i++) {
            int a[] = intervals[i];
            int firstRight = array[1];
            int secondLeft = a[0];
            int secondRight = a[1];
            if (firstRight >= secondLeft) {
                array[1] = Math.max(firstRight, secondRight);
            } else {
                array = a;
                list.add(array);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
