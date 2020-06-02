package ds.algos.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarrayTest {
    private MaximumSubarray maximumSubarray = new MaximumSubarray();

    @Test
    public void testMaximumSubarray() {
        int array[] = {-2,1,-3,4,-1,2,1,-5,4};
        assertEquals(6, maximumSubarray.maxSubArray(array));
    }

    @Test
    public void testMaximumSubarray2() {
        int array[] = {-2,-1};
        assertEquals(-1, maximumSubarray.maxSubArray(array));
    }

    @Test
    public void testMaximumSubarray3() {
        int array[] = {2,1};
        assertEquals(3, maximumSubarray.maxSubArray(array));
    }
}
