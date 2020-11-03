package ds.algos.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

public class MinRemoveToMakeValid {

    public static void main(String[] args) {
        MinRemoveToMakeValid valid = new MinRemoveToMakeValid();
//        System.out.println(valid.minRemoveToMakeValid("(())(("));
//        System.out.println(valid.minRemoveToMakeValid("lee(t(c)o)de)"));
//        System.out.println(valid.minRemoveToMakeValid("a)b(c)d"));
//
//        System.out.println(valid.minRemoveToMakeValidCharArray("(())(("));
//        System.out.println(valid.minRemoveToMakeValidCharArray("lee(t(c)o)de)"));
        System.out.println(valid.minRemoveToMakeValidCharArray("a)b(c)d"));
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

    public String minRemoveToMakeValidCharArray(String s) {

        char[] chars = s.toCharArray();
        Deque<Integer> st = new LinkedList<>();

        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (c == '(') {
                st.push(i);
            } else if (c == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    chars[i]='*';
                }
            }
        }

        while (!st.isEmpty())
            chars[st.pop()] = '*';
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<chars.length ; i++) {
            if(chars[i] != '*')
                sb.append(chars[i]);
        }

        return sb.toString().replaceAll("\\*", "");
    }


}
