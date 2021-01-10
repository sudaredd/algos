package ds.algos.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class FindKthLargest {

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>();
        
        for(int num : nums) {
            if(queue.size() < k ) {
                queue.offer(num);
            } else if(queue.peek() < num) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.peek();
    }
}
