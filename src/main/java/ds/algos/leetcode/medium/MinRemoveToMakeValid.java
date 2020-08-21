package ds.algos.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

public class MinRemoveToMakeValid {

    public static void main(String[] args) {
        MinRemoveToMakeValid valid = new MinRemoveToMakeValid();
        System.out.println(valid.minRemoveToMakeValid("(())(("));
        System.out.println(valid.minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> st = new LinkedList<>();

        for (int i = 0; i < sb.length(); ++i) {
            char c = sb.charAt(i);
            if (c == '(') {
                st.push(i);
            } else if (c == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }

        while (!st.isEmpty())
            sb.setCharAt(st.pop(), '*');

        return sb.toString().replaceAll("\\*", "");
    }


}
