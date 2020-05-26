package ds.algos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ds.algos.FirstNonRepeatedCharacter.firstNonRepeatedChar;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstNonRepeatedCharacterTest {

    @Test
    public void testFirstNonRepeatedCharacter() {
        assertEquals('c', firstNonRepeatedChar("abcba"));
        assertEquals('d', firstNonRepeatedChar("abcbacd"));
        assertEquals('g', firstNonRepeatedChar("abccgba"));
    }

    @Test
    public void testFirstNonRepeatedCharacterDefault() {
        assertEquals('_', firstNonRepeatedChar("aabbcc"));
    }
}
