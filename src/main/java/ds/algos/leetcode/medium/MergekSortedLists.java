package ds.algos.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class MergekSortedLists {

    public static void main(String[] args) {
        ListNode first = new ListNode(2);
        first.next = new ListNode(3);
        first.next.next = new ListNode(5);
        first.next.next.next = new ListNode(6);

        ListNode second = new ListNode(1);
        second.next = new ListNode(4);
        second.next.next = new ListNode(6);

        System.out.println(new MergekSortedLists().mergeKLists(new ListNode[]{first, second}));
    }

    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        PriorityQueue<ListNode> queue= new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        Arrays.stream(lists).forEach(queue::offer);

        ListNode l = new ListNode(0);
        ListNode temp = l;
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
            if(temp.next != null) {
                queue.add(temp.next);
            }
        }
        return l.next;
    }

}
