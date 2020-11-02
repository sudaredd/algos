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
        System.out.println(removeDuplicates("aaacc", 3));

        System.out.println(removeDuplicates("aaabbbc", 3));
        System.out.println(removeDuplicates("aabbbacd", 3));

        System.out.println(removeDuplicates_practice("aaabbbc", 3));
        System.out.println(removeDuplicates_practice("aabbbacd", 3));
    }

    public static String removeDuplicates(String s, int k) {

        Stack<Candy> stack = new Stack<>();

        stack.push(new Candy(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            char val = s.charAt(i);

            if (!stack.isEmpty() && stack.peek().value == val) {
                Candy candy = stack.pop();
                if (candy.occurrances < k-1 ) {
                    candy.occurrances += 1;
                    stack.push(candy);
                }
            } else {
                stack.push(new Candy(val));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Candy candy = stack.pop();
            for(int i=0; i<candy.occurrances; i++)
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
                if (candy.occurrances < k - 1) {
                    candy.occurrances = candy.occurrances + 1;
                    stack.push(candy);
                }
            } else {
                stack.push(new Candy(s.charAt(i)));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Candy candy = stack.pop();
            for(int i=0; i<candy.occurrances; i++)
                stringBuilder.insert(0, candy.value);
        }
        return stringBuilder.toString();
    }

    static class Candy {
        char value;
        int occurrances = 1;

        Candy(char c) {
            value = c;
        }
    }


}
