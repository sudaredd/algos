package ds.algos.bbg;

import java.util.HashMap;
import java.util.Map;

class Node {
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }


}

public class LRUCache {

    Node head;
    Node tail;
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int size) {
        this.capacity = size;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(3,2);

        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        lruCache.put(4,3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.map);
    }

    private int get(int k) {
        if(map.containsKey(k)) {
            Node node = map.get(k);
            int res = node.val;
            delete(node);
            setHead(node);
            return res;
        }
        return -1;
    }

    public void put(int key, int val) {

        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = val;
            delete(node);
            setHead(node);
        } else {
            Node node = new Node(key, val);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                delete(tail);
            }
            setHead(node);
            map.put(key, node);

        }

    }

    private void setHead(Node node) {

        node.next = head;
        node.prev = null;

        if(head != null) {
            head.prev = node;
        }
        head = node;
        if(tail==null)
            tail = head;
    }

    private void delete(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else
            tail = node.prev;
    }
}
