package ds.algos.bbg;

import static ds.algos.bbg.StringToInteger.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerTest {

    @Test
    void stringToIntegerTest() {
        assertEquals(12456, stringToInteger("12456"));
        assertEquals(23456, stringToInteger("23456"));
        assertEquals(-12456, stringToInteger("-12456"));
    }
}