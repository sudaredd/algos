package ds.algos.bbg;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Example 1:
 * <p>
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 * <p>
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 * <p>
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * Example 4:
 * <p>
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 */
public class RemoveParenthesis {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }

    public static String minRemoveToMakeValid(String s) {

        char c[] = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                stack.push(i);
            } else if (c[i] == ')') {
                if (stack.isEmpty()) {
                    c[i] = '*';
                } else stack.pop();
            }
        }
        while (!stack.isEmpty())
            c[stack.pop()] = '*';

        StringBuilder stringBuilder = new StringBuilder();

        for (char c1 : c) {
            if (c1 != '*') {
                stringBuilder.append(c1);
            }
        }
        return stringBuilder.toString().trim();
    }
}
