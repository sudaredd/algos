package ds.algos.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * <p>
 * LFUCache lFUCache = new LFUCache(2);
 * lFUCache.put(1, 1);
 * lFUCache.put(2, 2);
 * lFUCache.get(1);      // return 1
 * lFUCache.put(3, 3);   // evicts key 2
 * lFUCache.get(2);      // return -1 (not found)
 * lFUCache.get(3);      // return 3
 * lFUCache.put(4, 4);   // evicts key 1.
 * lFUCache.get(1);      // return -1 (not found)
 * lFUCache.get(3);      // return 3
 * lFUCache.get(4);      // return 4
 * https://leetcode.com/problems/lfu-cache/discuss/513157/Java-O(1)-16-ms-(beating-97)-using-2-HashMaps-and-DoublyLinkedList-with-detailed-explanations
 */
public class LFUCache {

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Map<Integer, NodeDLinkedList> freqNodeDMap = new HashMap<>();
    Node head;
    Node tail;
    int minimumFrequency = 1;


    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1);
        lFUCache.put(2, 2);
        System.out.println("get 1:" + lFUCache.get(1));      // return 1
        lFUCache.put(3, 3);   // evicts key 2
        System.out.println(lFUCache.get(2));      // return -1 (not found)
        System.out.println(lFUCache.get(3));      // return 3
        lFUCache.put(4, 4);   // evicts key 1.
        System.out.println(lFUCache.get(1));      // return -1 (not found)
        System.out.println(lFUCache.get(3));      // return 3
        System.out.println(lFUCache.get(4));      // return 4
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        int val = node.val;

        incrementFrequency(node);

        return val;
    }

    private void incrementFrequency(Node node) {
        int oldFrequency = node.freq;

        if (freqNodeDMap.containsKey(oldFrequency)) {
            NodeDLinkedList nodeDLinkedList = freqNodeDMap.get(oldFrequency);
            nodeDLinkedList.remove(node);
            if (node.freq == minimumFrequency && nodeDLinkedList.length == 0) {
                minimumFrequency++;
            }
        }
        int newfrequency = oldFrequency + 1;
        node.freq = newfrequency;
        NodeDLinkedList nodeDLinkedList = freqNodeDMap.getOrDefault(newfrequency, new NodeDLinkedList());
        nodeDLinkedList.add(node);
        freqNodeDMap.put(newfrequency, nodeDLinkedList);
    }

    public void put(int key, int val) {

        if (capacity <= 0)
            return;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = val;
            incrementFrequency(node);
        } else {
            Node node = new Node(key, val);
            if (map.size() == capacity) {
                Node nodeToRemove = freqNodeDMap.get(minimumFrequency).removeLastNode();
                map.remove(nodeToRemove.key);
            }
            map.put(key, node);
            incrementFrequency(node);
            minimumFrequency = 1;
        }
    }

}

class NodeDLinkedList {
    Node head;
    Node tail;
    int length;

    void add(Node node) {
        node.prev = null;

        node.next = head;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null)
            tail = head;

        length++;
    }

    public void remove(Node node) {

        if (node == head) {
            if (node == tail) {
                tail = null;
            }
            head = head.next;
        } else {
            node.prev.next = node.next;
            if (node == tail) {
                tail = node.prev;
            } else {
                node.next.prev = node.prev;
            }
        }
        length--;

    }

    public Node removeLastNode() {
        Node last = tail;

        if (last != null) {
            remove(last);
        }

        return last;
    }
}

class Node {
    Node next;
    Node prev;
    int val;
    int key;
    int freq;

    Node(int k, int v) {
        val = v;
        key = k;
    }

}
