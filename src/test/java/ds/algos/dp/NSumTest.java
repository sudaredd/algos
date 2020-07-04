package ds.algos.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NSumTest {

    @Test
    void nSum() {
        NSum nSum = new NSum();
        assertEquals(3, nSum.nSum(2));
        assertEquals(1, nSum.nSum(1));
        assertEquals(55, nSum.nSum(10));
    }
}