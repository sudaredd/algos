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

//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, ((o1, o2) -> Integer.compare(o1[0],o2[0] )));
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

    public int[][] merge_practice1(int[][] intervals) {

        List<int[]> intervalsL = new ArrayList<>();

        int current[] = intervals[0];

        intervalsL.add(current);

        for(int[] interval : intervals) {

            int currentEnd = current[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if(currentEnd >= nextBegin) {
                int res = Math.max(currentEnd, nextEnd);
                current[1] = res;
            } else {
                current = interval;
                intervalsL.add(current);
            }
        }

        return intervalsL.toArray(new int[intervalsL.size()][]);

    }


}
