package ds.algos.bbg;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class MinQueue extends LinkedBlockingQueue<Integer> {

    private LinkedList<Integer> minQueue = new LinkedList();

    public static void main(String[] args) {
        MinQueue minQueue = new MinQueue();
        minQueue.add(5);
        minQueue.add(7);
        minQueue.add(4);
        minQueue.add(6);


        System.out.println(minQueue.minQueue);
        System.out.println(minQueue.getMin());

        minQueue.remove();
        minQueue.remove();
        minQueue.remove();
        System.out.println(minQueue.getMin());
    }

    public boolean add(int val) {
        super.add(val);
        if (minQueue.isEmpty() || minQueue.peek() < val) {
            minQueue.add(val);
        } else {
            int count = 0;
            while (!minQueue.isEmpty() && val < minQueue.peek()) {
                minQueue.remove();
                count++;
            }
            while (count-- >= 0) {
                minQueue.addLast(val);
            }
        }
        return true;
    }

    public Integer remove() {
        minQueue.remove();
        return super.remove();
    }

    public int getMin() {
        return minQueue.peek();
    }
}
