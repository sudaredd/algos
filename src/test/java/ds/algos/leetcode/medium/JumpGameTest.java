package ds.algos.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JumpGameTest {
    private JumpGame jumpGame = new JumpGame();

    @Test
    public void testJumpGame1() {
        assertTrue(jumpGame.canJump(new int[]{2,3,1,1,4}));
    }
    @Test
    public void testJumpGame2() {
        assertFalse(jumpGame.canJump(new int[]{3,2,1,0,4}));
    }

    @Test
    public void testJumpGame3() {
        assertTrue(jumpGame.canJump(new int[]{3,2,2,0,4}));
    }
}
