package ds.algos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ds.algos.BalancedParanthesis.isBalancedParanthesis;
import static org.junit.jupiter.api.Assertions.*;

public class BalancedParanthesisTest {

    @Test
    public void testBalancedTrue() {
        assertTrue(isBalancedParanthesis("({[]})"));
        assertTrue(isBalancedParanthesis("({[]})()"));
    }

    @Test
    public void testBalancedFalse() {
        assertFalse(isBalancedParanthesis("({[]})("));
        assertFalse(isBalancedParanthesis("({[]}))"));
    }
}
