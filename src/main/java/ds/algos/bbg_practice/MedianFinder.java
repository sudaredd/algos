package ds.algos.bbg_practice;

import java.util.PriorityQueue;

public class MedianFinder {
    public static void main(String[] args) {
        runTest1();
        runTest2();
    }

    private static void runTest2() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.add(1);
        medianFinder.add(2);
        System.out.println(medianFinder.median());

        medianFinder.add(3);

        System.out.println(medianFinder.median());
    }

    private static void runTest1() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.add(7);
        medianFinder.add(5);
        medianFinder.add(10);
        medianFinder.add(9);
        medianFinder.add(3);

        System.out.println(medianFinder.median());
    }

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);

    private void add(int i) {

        maxHeap.offer(i);

        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

    }

    private double median() {
        if(maxHeap.size()==minHeap.size()) {
            return  (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else
            return maxHeap.peek();
    }

}
