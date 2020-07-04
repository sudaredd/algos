package ds.algos.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        list.add(current);
        for (int[] interval : intervals) {
            int currentEnd = current[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            if (currentEnd >= nextBegin) {
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                current = interval;
                list.add(current);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length < 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int results[][] = new int[intervals.length][intervals[0].length];
        int pos = 0;
        int first[] = intervals[0];

        for (int i = 0; i < intervals.length - 1; i++) {
            int second[] = intervals[i + 1];
            if (first[first.length - 1] >= second[0]) {
                int[] res = new int[]{first[0], Math.max(first[first.length - 1], second[1])};
                results[pos++] = res;
                first = res;
                i++;
            } else {
                results[pos++] = first;
                results[pos++] = second;
            }
        }
        int results2[][] = new int[pos][2];

        System.arraycopy(results, 0, results2, 0, pos);

        System.out.println(pos);
        return results2;
    }
}
