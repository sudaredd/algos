package ds.algos.bbg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    @Test
    void add() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.add(7);
        medianFinder.add(5);
        medianFinder.add(10);
        medianFinder.add(9);
        medianFinder.add(3);

        System.out.println(medianFinder.median());
    }
 @Test
    void add1() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.add(1);
        medianFinder.add(2);
     System.out.println(medianFinder.median());

     medianFinder.add(3);

        System.out.println(medianFinder.median());
    }

}