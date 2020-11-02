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
 */
public class LFUCache {

    public static void main(String[] args) {
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1);
        lFUCache.put(2, 2);
        System.out.println("get 1:"+lFUCache.get(1));      // return 1
        lFUCache.put(3, 3);   // evicts key 2
        System.out.println(lFUCache.get(2));      // return -1 (not found)
        System.out.println(lFUCache.get(3));      // return 3
        lFUCache.put(4, 4);   // evicts key 1.
        System.out.println(lFUCache.get(1));      // return -1 (not found)
        System.out.println(lFUCache.get(3));      // return 3
        System.out.println(lFUCache.get(4));      // return 4
    }

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        int val = node.val;
        remove(node);
        setHead(node);

        return val;
    }

    public void put(int key, int val) {

        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = val;
            remove(node);
            setHead(node);
        } else {
            Node node = new Node(key, val);
            if (map.size() < capacity) {
                setHead(node);
            } else {
                map.remove(tail.key);
                remove(tail);
                setHead(node);
            }
            map.put(node.key, node);
        }


    }

    private void remove(Node node) {

        System.out.println("remove "+node.key);
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail=node.prev;
        }
    }

    private void setHead(Node node) {
        System.out.println("add node "+node.key);
        node.next = head;
        node.prev = null;

        if(head !=null) {
            head.prev = node;
        }
        head =node;

        if(tail==null) {
            tail = head;
        }
    }

    class Node {
        Node next;
        Node prev;
        int val;
        int key;
        int counter;

        Node() {

        }

        Node(int k, int v) {
            val = v;
            key = k;
        }

        public void increment() {
            counter++;
        }

        public int getCounter() {
            return counter;
        }
    }
}
