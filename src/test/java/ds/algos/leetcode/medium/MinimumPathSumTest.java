package ds.algos.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimumPathSumTest {
    private MinimumPathSum minimumPathSum = new MinimumPathSum();

    @Test
    public void testMinimumPathSum() {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        Assertions.assertEquals(7, minimumPathSum.minPathSum(grid));
    }
}
