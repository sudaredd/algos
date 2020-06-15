package ds.algos.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobTest {

    @Test
    public void testRob() {
        Assertions.assertEquals(4, new Rob().rob(new int[]{1,2,3,1}));
        Assertions.assertEquals(12, new Rob().rob(new int[]{2,7,9,3,1}));
        Assertions.assertEquals(16, new Rob().rob(new int[]{2,7,9,3,1,5}));
    }
}
