package ds.algos.bbg_practice;

import java.util.Stack;

public class MinStack<Integer> extends Stack<Integer> {

    private final Stack<Integer> minStack = new Stack<>();

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

    @Override
    public Integer push(Integer item) {
        super.push(item);
        if (minStack.isEmpty() || (int) minStack.peek() > (int) item) {
            minStack.push(item);
        } else {
            minStack.push(minStack.peek());
        }
        return item;
    }

    @Override
    public Integer pop() {
        minStack.pop();
        Integer item = super.pop();
        return item;
    }

    public Integer top() {
        return super.peek();
    }

    public Integer min() {
        return minStack.peek();
    }
}
