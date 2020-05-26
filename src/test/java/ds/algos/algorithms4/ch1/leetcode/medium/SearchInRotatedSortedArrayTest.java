package ds.algos.algorithms4.ch1.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInRotatedSortedArrayTest {
    private SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();

    @Test
    public void testSortedBinary() {
        int nums [] = {4,5,6,7,0,1,2};
        int index = searchInRotatedSortedArray.search(nums, 0);
        assertEquals(4, index);
    }
}
