package ds.algos.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReorderLogFilesTest {

    @Test
    public void testReorderLogFiles() {
        String logs[] = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] reorderLogs = new ReorderLogFiles().reorderLogFiles(logs);
        assertEquals("let1 art can", reorderLogs[0]);
        assertEquals("let3 art zero", reorderLogs[1]);
        assertEquals("let2 own kit dig", reorderLogs[2]);
        assertEquals("dig2 3 6", reorderLogs[4]);
    }
}
