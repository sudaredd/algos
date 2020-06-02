package ds.algos.amazon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncodeCharsTest {

    @Test
    public void testEncodeChars() {
        assertEquals("2a2b2c1a",new EncodeChars().encodeChars("aabbcca"));
        assertEquals("1a1b1c1d1e1t", new EncodeChars().encodeChars("abcdet"));
        assertEquals("1g", new EncodeChars().encodeChars("g"));
    }
}
