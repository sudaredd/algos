package ds.algos.bbg;

import java.util.Stack;

/**
 * Input: "aaabbbc"
 * Output: "c"
 * Explanation:
 * 1. Remove 3 'a': "aaabbbbc" => "bbbbc"
 * 2. Remove 4 'b': "bbbbc" => "c"
 * <p>
 * Input: "aabbbacd"
 * Output: "cd"
 * Explanation:
 * 1. Remove 3 'b': "aabbbacd" => "aaacd"
 * 2. Remove 3 'a': "aaacd" => "cd"
 */
public class CandyCrush {


    public static void main(String[] args) {
        System.out.println(removeDuplicates("aaaacc", 3));
        System.out.println(removeDuplicatesWithStacks("aaaacc", 3));
        System.out.println(removeDuplicatesWithStacksKOrMore("aaaacc", 3));

        System.out.println(removeDuplicates("aabbbaacd", 3));
        System.out.println(removeDuplicatesWithStacks("aabbbaacd", 3));
        System.out.println(removeDuplicatesWithStacksKOrMore("aabbbaacd", 3));

        System.out.println(removeDuplicates_practice("aaabbbc", 3));
        System.out.println(removeDuplicates_practice("aabbbacd", 3));
    }

    public static String removeDuplicates(String s, int k) {

        Stack<Candy> stack = new Stack<>();

//        stack.push(new Candy(s.charAt(0)));

        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);

            if (!stack.isEmpty() && stack.peek().value == val) {
                Candy candy = stack.pop();
                if (candy.occurrences < k - 1) {
                    candy.occurrences += 1;
                    stack.push(candy);
                }
            } else {
                stack.push(new Candy(val));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Candy candy = stack.pop();
            for (int i = 0; i < candy.occurrences; i++)
                stringBuilder.insert(0, candy.value);
//            stringBuilder.append(stack.pop().value);
        }
        return stringBuilder.toString();
    }

    public static String removeDuplicates_practice(String s, int k) {
        Stack<Candy> stack = new Stack<>();

        stack.push(new Candy(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek().value == s.charAt(i)) {
                Candy candy = stack.pop();
                if (candy.occurrences < k - 1) {
                    candy.occurrences = candy.occurrences + 1;
                    stack.push(candy);
                }
            } else {
                stack.push(new Candy(s.charAt(i)));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Candy candy = stack.pop();
            for (int i = 0; i < candy.occurrences; i++)
                stringBuilder.insert(0, candy.value);
        }
        return stringBuilder.toString();
    }

    public static String removeDuplicatesWithStacks(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> counter = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                int count = counter.pop();
                stack.pop();
                if (count < k - 1) {
                    count++;
                    counter.push(count);
                    stack.push(c);
                }
            } else {
                stack.push(c);
                counter.push(1);
            }
        }
        StringBuilder sb = finalResult(stack, counter);
        return sb.toString();
    }

    public static String removeDuplicatesWithStacksKOrMore(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> counter = new Stack<>();

        char lastChar = '~';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                int count = counter.pop();
                stack.pop();
                if (count < k - 1) {
                    count++;
                    counter.push(count);
                    stack.push(c);
                } else {
                    lastChar = c;
                }
            } else {
                if(lastChar ==c)
                    continue;
                stack.push(c);
                counter.push(1);
                lastChar = '~';
            }
        }
        StringBuilder sb = finalResult(stack, counter);
        return sb.toString();
    }

    private static StringBuilder finalResult(Stack<Character> stack, Stack<Integer> counter) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            int count = counter.pop();
            while (count > 0) {
                sb.insert(0, c);
                count--;
            }
        }
        return sb;
    }

    static class Candy {
        char value;
        int occurrences = 1;

        Candy(char c) {
            value = c;
        }
    }


}
