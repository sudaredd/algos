package ds.algos.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumProfitTest {

    @Test
    public void testMaximumProfitTest() {
        Assertions.assertEquals(5, new MaximumProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assertions.assertEquals(0, new MaximumProfit().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
