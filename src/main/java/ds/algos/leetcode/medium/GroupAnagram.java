package ds.algos.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            String key = sort(str);
            map.computeIfAbsent(key, k->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String str) {
        char [] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
