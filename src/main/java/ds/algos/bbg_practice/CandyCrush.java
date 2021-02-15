package ds.algos.bbg_practice;

import java.util.Stack;

public class CandyCrush {

    public static void main(String[] args) {
        System.out.println(removeDuplicatesWithKOrMore("aabbbaccd", 3));
        System.out.println(removeDuplicatesWithKOrMore("aaabbbacd", 3));
        System.out.println(removeDuplicatesWithKOrMore("aabbaacd", 3));

    }

    private static String removeDuplicatesWithKOrMore(String str, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> counter = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            int count = 1;

            while (i < str.length()-1 && str.charAt(i+1)==c) {
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
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            int c1 = counter.pop();
            while (c1-- > 0) {
                sb.insert(0, c);
            }
        }

        return sb.toString();
    }
}
