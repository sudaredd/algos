package ds.algos.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeIntervalsTest {
    @Test
    public void testMergeIntervals() {
        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] input = new int[][]{{1,4},{4,5}};
//        int[][] input = new int[][]{{1,4},{0,4}};
//        int[][] input = new int[][]{{1,4},{2,3}};
//        int[][] input = new int[][]{{1,4},{0,2},{3,5}};
        int res[][] = new MergeIntervals().merge(input);
        for (int[] out : res) {
            System.out.println(Arrays.toString(out));
        }

        Assertions.assertEquals(3, res.length);
        int res2[] = res[2];
        Assertions.assertEquals(15, res2[0]);
        Assertions.assertEquals(18, res2[1]);
    }
}
