package ds.algos.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinPaidStairCaseTest {

    @Test
    void minPaidStairCase() {
        MinPaidStairCase minPaidStairCase = new MinPaidStairCase();

        int minCost = minPaidStairCase.minPaidStairCase(3, new int[]{0, 2, 3, 4});

        assertEquals(6, minCost);
    }

    @Test
    void minPaidStairCasePath() {

        MinPaidStairCase minPaidStairCase = new MinPaidStairCase();

        List<Integer> minCost = minPaidStairCase.minPaidStairCasePath(8, new int[]{0, 3, 2, 4, 6, 1, 1, 5, 3});
                                        //total cost for each pos                     0, 3, 2, 6, 8, 7, 8, 12, 11
                                        //walk from end                               8, 6, 5, 3, 2, 0
                                        //revere walk                                 0, 2, 3, 5, 6, 8

        assertEquals(Arrays.asList(0, 2, 3, 5, 6, 8), minCost);
    }
}