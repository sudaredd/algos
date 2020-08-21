package ds.algos.amazon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeCharsTest {

    @Test
    public void testDecode() {

        assertEquals("aaabbc", new DecodeChars().decodeChar("a3b2c1"));
        assertEquals("abcd", new DecodeChars().decodeChar("a1b1c1d1"));
    }

}