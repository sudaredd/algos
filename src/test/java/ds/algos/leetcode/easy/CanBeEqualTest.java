package ds.algos.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanBeEqualTest {

    @Test
    public void testCanBeEqual() {
        assertTrue(new CanBeEqual().canBeEqual(new int[] {1,2,3,4}, new int[]{2,4,1,3}));
        assertTrue(new CanBeEqual().canBeEqual(new int[] {7}, new int[]{7}));
        assertTrue(new CanBeEqual().canBeEqual(new int[] {1,12}, new int[]{1,12}));
        assertFalse(new CanBeEqual().canBeEqual(new int[] {3,7,9}, new int[]{3,7,11}));
        assertTrue(new CanBeEqual().canBeEqual(new int[] {900, 1000, 997, 400}, new int[]{400,1000,900, 997}));
    }
}
