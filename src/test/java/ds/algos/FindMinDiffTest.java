package ds.algos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinDiffTest {

    @Test
    void findMinDiff() {

        int arr[] = new int[]{1, 5, 3, 19, 18, 25};

        int minDiff = FindMinDiff.findMinDiff(arr);

        System.out.println("minDiff::"+minDiff);

    }
}