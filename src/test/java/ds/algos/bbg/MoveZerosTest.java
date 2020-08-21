package ds.algos.bbg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosTest {

    @Test
    void moveZeros() {

        int arr[] = {0, 1, 0, 3, 12};

        new MoveZeros().moveZeros(arr);

        int expected[] = {1, 3, 12, 0, 0};

        Assertions.assertArrayEquals(expected, arr);
    }
}