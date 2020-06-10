package ds.algos.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnagramTest {

    @Test
    public void testIsAnagram() {
        Anagram anagram = new Anagram();
        String s = "anagram", t = "nagaram";
        Assertions.assertTrue(anagram.isAnagram(s,t));
        s = "rat"; t = "car";
        Assertions.assertFalse(anagram.isAnagram(s,t));

    }
}
