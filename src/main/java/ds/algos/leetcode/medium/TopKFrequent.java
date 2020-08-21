package ds.algos.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent(new int[]{3, 0, 1, 3, 1}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, v) -> v == null ? 1 : v + 1);
        }

    /*   return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k).
                mapToInt(i->i.getKey()).toArray();*/

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        map.keySet().stream().forEach(priorityQueue::offer);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}
