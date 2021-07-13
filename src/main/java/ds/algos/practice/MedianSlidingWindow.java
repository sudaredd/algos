package ds.algos.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianSlidingWindow {



    public static void main(String[] args) {
        MedianSlidingWindow medianSlidingWindow = new MedianSlidingWindow();
   /*     double[] res = medianSlidingWindow.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(res));

       double[] res1 = medianSlidingWindow.medianSlidingWindow(new int[]{1,2,3,4,2,3,1,4,2}, 3);
        System.out.println(Arrays.toString(res1));
*/
/*        double[] res2 = medianSlidingWindow.medianSlidingWindow(new int[]{1,4,2,3}, 4);
        System.out.println(Arrays.toString(res2));
        */
        double[] res3 = medianSlidingWindow.medianSlidingWindow(new int[]{-2147483648,-2147483648,2147483647,-2147483648,-2147483648,
                            -2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 2);
        System.out.println(Arrays.toString(res3));
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int begin = 0;
        int move = 0;
        double res[] = new double[nums.length - k + 1];
        int pointer = 0;
        while (move < nums.length) {
            maxHeap.offer(nums[move]);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            move++;
            if(move - begin == k) {
                if(k%2==0) {
//                    low + (high-low)/2;
                    res[pointer++] = ((double)maxHeap.peek() + minHeap.peek())/2 ;
                } else {
                    res[pointer++] = (double) maxHeap.peek();
                }
                if(maxHeap.peek() >= nums[begin]) {
                    maxHeap.remove(nums[begin++]);
                } else
                    minHeap.remove(nums[begin++]);
            }
        }
        return res;

    }
}
