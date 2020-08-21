package ds.algos.bbg;

import java.util.Stack;

public class MinStack extends Stack<Integer> {

    private Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());    //  --> Returns 0.
        System.out.println(minStack.min()); //  --> Returns -2.
    }

    private int top() {

        return super.peek();

    }

    public void push(int val) {

        super.push(val);

        minStack.push(minStack.isEmpty() || val < min() ? val : min());
    }

    public Integer pop() {

        minStack.pop();

        return super.pop();
    }

    public int min() {

        return minStack.peek();

    }
}
