package ds.algos.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {
    private TwoSum twoSum = new TwoSum();

    @Test
    public void testTwoSum() {
       int res[] =  twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertTrue(res != null);
        assertArrayEquals(new int[] {0,1}, res);
    }
}
