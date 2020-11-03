package ds.algos.linkedList;

import java.util.*;

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
        System.out.println(new MergeKSortedList().mergeKListsPriority(lists));
        System.out.println(new MergeKSortedList().mergeKListsPriority_practice(lists));

        ListNode test2 = new ListNode(-2);
        test2.next = new ListNode(-1);
        test2.next.next = new ListNode(-1);
        test2.next.next.next = new ListNode(-1);

        ListNode res = new MergeKSortedList().mergeKListsPriority_practice(new ListNode[]{test2});
        System.out.println(res);

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

    public ListNode mergeKListsPriority(ListNode[] lists) {
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

    public ListNode mergeKListsPriority_practice(ListNode[] lists) {

        ListNode listNode = new ListNode(0);
        ListNode current = listNode;

        Queue<ListNode> listNodes = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.getVal() == l2.getVal() ? 0 : l1.val > l2.val ? 1 : -1;
            }
        });

//        (l1, l2)-> l1.getVal() - l2.getVal()

        for(ListNode listNode1 : lists) {
            while (listNode1 != null) {
                listNodes.offer(listNode1);
                listNode1 = listNode1.next;
            }
        }
        while (!listNodes.isEmpty()) {
            ListNode node = listNodes.poll();
            current.next = node;
            current = current.next;
        }
        return listNode.next;
    }



















}
