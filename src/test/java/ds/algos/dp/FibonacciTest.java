package ds.algos.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {
    private Fibonacci fibonacci = new Fibonacci();

    @Test
    public void testFibonacci() {
        int res[] = fibonacci.fib(4);
        assertEquals(1, res[2]);
        assertEquals(3, res[4]);
    }
}
