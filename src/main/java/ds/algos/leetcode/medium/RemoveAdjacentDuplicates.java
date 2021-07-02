package ds.algos.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
 * <p>
 * We repeatedly make k duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 * <p>
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 * <p>
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 */
public class RemoveAdjacentDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }
    public static String removeDuplicates(String s, int k) {
        Deque<Character> stack = new LinkedList<>();
        Deque<Integer> counterStack = new LinkedList<>();
        char[] ary = s.toCharArray();
        for (char c : ary) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                counterStack.push(1);
            } else {
                if (counterStack.peek() == k - 1) {
                    counterStack.pop();
                    stack.pop();
                } else {
                    int count = counterStack.pop();
                    counterStack.push(count + 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            int count = counterStack.pop();
            while (count-- > 0) {
                sb.insert(0, c);
            }
        }
        return sb.toString();
    }
}
