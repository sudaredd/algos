package ds.algos.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromTest {

    @Test
    public void testIsPalindrom() {
        Assertions.assertTrue(new Palindrome().isPalindrome("A man, a plan, a canal: Panama"));
        Assertions.assertFalse(new Palindrome().isPalindrome("race a car"));
        Assertions.assertFalse(new Palindrome().isPalindrome("0P"));
    }
}
