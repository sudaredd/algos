package ds.algos;

import java.util.Map;
import java.util.Stack;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

public class BalancedParanthesis {
    static Map<Character, Character> map = ofEntries(
                                            entry('(', ')'),
                                            entry('{', '}'),
                                            entry('[', ']')
                                            );

    public static boolean isBalancedParanthesis(String paranthesis) {
        Stack<Character> stack = new Stack<>();
        for(char c :paranthesis.toCharArray()) {
            if(map.containsKey(c))
                stack.push(c);
            else if(stack.isEmpty() || c != map.get(stack.pop()))
                return false;
        }
        return stack.isEmpty();
    }
}
