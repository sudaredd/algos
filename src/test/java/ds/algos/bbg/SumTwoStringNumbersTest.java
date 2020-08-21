package ds.algos.bbg;

import org.junit.jupiter.api.Test;

import static ds.algos.bbg.SumTwoStringNumbers.*;
import static org.junit.jupiter.api.Assertions.*;

class SumTwoStringNumbersTest {

    @Test
    void sum2StringNumsTest() {

        assertEquals(2345, sum2StringNums("2100", "245"));

        assertEquals(796, sum2StringNums("325", "471"));

        assertEquals(566, sum2StringNums("245", "321"));
    }

    @Test
    public void testTwoSums() {

        assertEquals("579", sumTwoStrings("123", "456"));

        assertEquals("2556", sumTwoStrings("2100", "456"));
    }
}