package ds.algos.linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        ListNode third = new ListNode(3);
        third.next = new ListNode(6);

        ListNode[] lists = {first, second, third};

        System.out.println(new MergeKSortedList().mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodeDataList = new ArrayList<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                nodeDataList.add(listNode.val);
                listNode = listNode.next;
            }
        }
        Collections.sort(nodeDataList);
        ListNode node = new ListNode(0);
        ListNode dummy = node;
        for (int val : nodeDataList) {
            dummy.next = (new ListNode(val));
            dummy = dummy.next;
        }
        return node.next;
    }

    public ListNode mergeKListsPririty(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                priorityQueue.add(listNode.val);
                listNode = listNode.next;
            }
        }
        ListNode node = new ListNode(0);
        ListNode dummy = node;
        while (!priorityQueue.isEmpty()) {
            dummy.next = (new ListNode(priorityQueue.remove()));
            dummy = dummy.next;
        }
        return node.next;
    }
}
