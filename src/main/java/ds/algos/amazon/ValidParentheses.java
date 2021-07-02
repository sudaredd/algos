package ds.algos.amazon;

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        System.out.println(isValid("{}()[]"));
        System.out.println(isValid("{}()[}"));
        System.out.println("---------------");
        System.out.println(isValidParenthesis("{}()[]"));
        System.out.println(isValidParenthesis("{}()[}"));
    }

    public static boolean isValidParenthesis(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && getClosedBrace(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static char getClosedBrace(Character ch) {
        switch (ch) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return '_';
        }
    }
}
