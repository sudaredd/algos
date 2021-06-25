package ds.algos.airbnb;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 */
public class MergeKLists {

    public static void main(String[] args) {
        var node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        var node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        var node3 = new ListNode(2);
        node3.next = new ListNode(6);

        var mergeKLists = new MergeKLists();
        System.out.println(mergeKLists.mergeKLists(new ListNode[]{node1, node2, node3}));
        System.out.println(mergeKLists.mergeKListsWithPQueue(new ListNode[]{node1, node2, node3}));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        var listNode = new ListNode(0);
        for (var node : lists) {
            listNode = merge(listNode, node);
        }
        return listNode.next;
    }

    public ListNode mergeKListsWithPQueue(ListNode[] lists) {
        var queue = new PriorityQueue<Integer>();
        for (var node : lists) {
            while (node != null) {
                queue.offer(node.val);
                node = node.next;
            }
        }
        var node = new ListNode();
        var temp = node;
        while (!queue.isEmpty()) {
            temp.next = new ListNode(queue.poll());
            temp = temp.next;
        }
        return node.next;
    }


    private ListNode merge(ListNode temp, ListNode node) {
        var res = new ListNode();
        var tempRes = res;
        while (temp != null && node != null) {
            if (temp.val < node.val) {
                tempRes.next = new ListNode(temp.val);
                temp = temp.next;
            } else {
                tempRes.next = new ListNode(node.val);
                node = node.next;
            }
            tempRes = tempRes.next;
        }
        while (temp != null) {
            tempRes.next = new ListNode(temp.val);
            temp = temp.next;
            tempRes = tempRes.next;
        }
        while (node != null) {
            tempRes.next = new ListNode(node.val);
            node = node.next;
            tempRes = tempRes.next;
        }

        return res.next;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            ", next=" + next +
            '}';
    }
}
