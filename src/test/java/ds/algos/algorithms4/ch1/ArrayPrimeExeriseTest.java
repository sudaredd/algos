package ds.algos.algorithms4.ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayPrimeExeriseTest {
    @Test
    public void testArrayPrimeExerise() {
        boolean [][] array = ArrayPrimeExerise.arrayPrimes(5,5);
        System.out.println(array);
        Assertions.assertTrue(array[3][3]);
        Assertions.assertTrue(array[3][2]);
        Assertions.assertFalse(array[3][4]);


    }
}
