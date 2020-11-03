package ds.algos.bbg;

import java.util.PriorityQueue;

public class MedianFinder_Practice {


    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder_Practice() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void add(int num) {

        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double median() {

        if(maxHeap.size()==minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek())/2;
        } else
            return maxHeap.peek();
    }
}
