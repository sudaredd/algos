package ds.algos.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbStairTest {

    @Test
    void climbStair() {
        ClimbStair climbStair = new ClimbStair();

        assertEquals(5, climbStair.climbStair(4));
        assertEquals(8, climbStair.climbStair(5));
        assertEquals(13, climbStair.climbStair(6));
    }

    @Test
    void climbStairWithLessMomory() {
        ClimbStair climbStair = new ClimbStair();

        assertEquals(5, climbStair.climbStairWithLessMomory(4));
        assertEquals(8, climbStair.climbStairWithLessMomory(5));
        assertEquals(13, climbStair.climbStairWithLessMomory(6));
    }
}