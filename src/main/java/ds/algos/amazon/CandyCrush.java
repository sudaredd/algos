package ds.algos.amazon;

import java.util.Stack;

public class CandyCrush {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("aaaac", 3));
        System.out.println(removeDuplicatesWithStacksKOrMore("aaaac", 3));
        System.out.println(removeDuplicates("aabbbaacccaad", 3));
        System.out.println(removeDuplicatesWithStacksKOrMore("aabbbaacccaad", 3));
    }

    private static String removeDuplicates(String str, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> counter = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                counter.push(1);
            } else {
                stack.pop();
                int count = counter.pop();
                if (count < 2) {
                    stack.push(c);
                    counter.push(count + 1);
                }
            }
        }
        return getResult(stack, counter);
    }

    private static String getResult(Stack<Character> stack, Stack<Integer> counter) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            int count = counter.pop();
            for (int i = 0; i < count; i++) {
                sb.insert(0, c);
            }
        }
        return sb.toString();
    }

    public static String removeDuplicatesWithStacksKOrMore(String str, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> counter = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = 1;
            while (i+1 < str.length()-1 && c==str.charAt(i+1)) {
                count++;
                i++;
            }
            if(!stack.isEmpty() && stack.peek()==c) {
                stack.pop();
                count = count + counter.pop();
            }
            if(count < k) {
                stack.push(c);
                counter.push(count);
            }
        }
        return getResult(stack, counter);
    }
}
