package ds.algos.algorithms4.ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchWithDepthTest {

    @Test
    public void testBinarySearch() {
        Assertions.assertEquals(3, BinarySearchWithDepth.binarySearch(3, new int[] {1, 2, 3, 5, 7, 9, 10, 14, 15}));
        Assertions.assertEquals(-1, BinarySearchWithDepth.binarySearch(0, new int[] {1, 2, 3, 5, 7, 9, 10, 14, 15}));
    }
}
