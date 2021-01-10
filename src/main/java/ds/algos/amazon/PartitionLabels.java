package ds.algos.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklijzxxz"));
    }

    public List<Integer> partitionLabels(String S) {

        List<Integer> list = new ArrayList<>();

        //find last positionId for each character
        int lastIndex[] = new int[26];

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }

        int i = 0;

        while (i < chars.length) {
            int end = lastIndex[chars[i] - 'a'];
            int j = i + 1;
            while (j != end) {
                    end = Math.max(end, lastIndex[chars[j] - 'a']);
                    j++;
            }
            list.add(j-i+1);
            i = j + 1;
            System.out.println(list);
        }


        return list;
    }
}
