package ds.algos.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * <p>
 * Input: S = "aaab"
 * Output: ""
 */
public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString_InNtime("aab"));
        System.out.println(reorganizeString_InNtime("aaab"));
        System.out.println(reorganizeString_InNtime("aaccbbd"));
    }

    public static String reorganizeString(String S) {

        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : S.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pQueue = new PriorityQueue<>((a, b) -> charCount.get(b) - charCount.get(a));

        pQueue.addAll(charCount.keySet());

        StringBuilder stringBuilder = new StringBuilder();
        while (pQueue.size() > 1) {
            char current = pQueue.poll();
            char next = pQueue.poll();

            stringBuilder.append(current).append(next);

            charCount.put(current, charCount.get(current) - 1);
            charCount.put(next, charCount.get(next) - 1);

            if (charCount.get(current) > 0) {
                pQueue.offer(current);
            }
            if (charCount.get(next) > 0) {
                pQueue.offer(next);
            }
        }

        if (!pQueue.isEmpty()) {
            char v = pQueue.poll();
            if (charCount.get(v) > 1) {
                return "";
            }
            stringBuilder.append(v);
        }

        return stringBuilder.toString();

    }

    public static String reorganizeString_InNtime(String S) {

        int hash[] = new int[26];

        for (char c : S.toCharArray()) {
            int pos = c - 'a';
            hash[pos]++;
        }
        int maxCount = 0;
        int pos = -1;
        for (int c = 0; c < hash.length; c++) {
            if (hash[c] > maxCount) {
                maxCount = hash[c];
                pos = c;
            }
        }
        if (maxCount > (S.length() + 1) / 2) {
            return "";
        }
        char res[] = new char[S.length()];
        int idx = 0;
        while (idx < res.length && hash[pos] > 0) {
            char c = (char) (pos + 'a');
            res[idx] = c;
            idx += 2;
            hash[pos]--;
        }
        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                char c = (char) (i + 'a');
                res[idx] = c;
                idx += 2;
                hash[i]--;
            }
        }
        return new String(res);
    }

}
