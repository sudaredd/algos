package ds.algos.bbg;

import java.util.Stack;

/**
 * Implement Queue with stacks
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 */
public class MyStackQueue {

    public static void main(String[] args) {
        MyStackQueue myStackQueue = new MyStackQueue();

        myStackQueue.push(1);
        myStackQueue.push(2);

        System.out.println(myStackQueue.peek());
        System.out.println(myStackQueue.pop());
        System.out.println(myStackQueue.peek());
        System.out.println(myStackQueue.empty());
    }

    private Stack<Integer> inFlow = new Stack<>();

    private Stack<Integer> outFlow = new Stack<>();

    public void push(int val) {
        inFlow.push(val);
    }

    public int pop() {
        if(outFlow.isEmpty()) {
            while (!inFlow.isEmpty()) {
                outFlow.push(inFlow.pop());
            }
        }
        return outFlow.pop();
    }

    public int peek() {
        if(outFlow.isEmpty()) {
            while (!inFlow.isEmpty()) {
                outFlow.push(inFlow.pop());
            }
        }
        return outFlow.peek();
    }

    public boolean empty() {
        return !(outFlow.size() > 0 || inFlow.size() >0);
    }
}
