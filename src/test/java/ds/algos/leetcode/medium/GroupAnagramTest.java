package ds.algos.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GroupAnagramTest {
    GroupAnagram groupAnagram = new GroupAnagram();
    @Test
    public void testGroupAnagrams() {
        String array[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res =  groupAnagram.groupAnagrams(array);
        assertNotNull(res);
        assertEquals(3, res.size());
    }
}
