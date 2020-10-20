package ds.algos.bbg;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap;

    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);

        this.minHeap = new PriorityQueue<>();
    }

    public void add(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double median() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else
        return maxHeap.peek();
    }
}
