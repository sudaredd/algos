package ds.algos.algorithms4.ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ds.algos.algorithms4.ch1.NFactorial.nFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NFactorialTest {

    @Test
    public void testNFactorial() {
        assertEquals(6, nFactorial(3));
        assertEquals(120, nFactorial(5));
        assertEquals(1, nFactorial(0));
    }
}
