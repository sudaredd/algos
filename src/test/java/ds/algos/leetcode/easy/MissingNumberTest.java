package ds.algos.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingNumberTest {
    @Test
    public void testMissingNumber() {
        Assertions.assertEquals(2, new MissingNumber().missingNumber(new int[] {3,0,1}));
        Assertions.assertEquals(8, new MissingNumber().missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
    }
}
