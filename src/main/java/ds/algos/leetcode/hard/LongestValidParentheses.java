package ds.algos.leetcode.hard;

import java.util.Stack;

/**
 * Example 1:
 * <p>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 * <p>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 * <p>
 * Input: s = ""
 * Output: 0
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses(""));
    }
    public static int longestValidParentheses(String s) {
        char c[] = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < c.length; i++) {
             if (c[i] == ')' && stack.size()>1 && c[stack.peek()] == '(') {
                stack.pop();
                max = Math.max(max , i-stack.peek());
            } else {
                 stack.push(i);
             }
        }
        return max;
    }
}
