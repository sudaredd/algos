package ds.algos.bbg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueCharTest {

    @Test
    void firstUniqueChar() {

        Assertions.assertEquals(0, new FirstUniqueChar().firstUniqueChar("leetcode"));
        Assertions.assertEquals(2, new FirstUniqueChar().firstUniqueChar("loveleetcode"));
    }
}