package ds.algos.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleNumberTest {
    private SingleNumber singleNumber = new SingleNumber();

    @Test
    public void testSingleNumber() {
        assertEquals(2, singleNumber.singleNumberXor(new int[]{1, 3, 5, 2, 3, 5, 1}));
    }
}
