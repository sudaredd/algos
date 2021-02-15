package ds.algos.datastructures;

import java.util.concurrent.atomic.AtomicInteger;

public class HashMapD<K,V> {

    private Node[] data = new Node[10];

    private AtomicInteger size = new AtomicInteger();

    public void put(K key, V val) {

        Node<K, V> entry = new Node(key, val);

        int hashCode = key.hashCode();
        int location = hashCode%data.length;

        Node obj = data[location];
        if(obj == null) {
            data[location] = entry;
            return;
        }
        while (obj.next != null) {
            if(obj.k.equals(key)) {
                obj.v = val;
                return;
            } else {
                obj = obj.next;
            }
        }
        obj.next = entry;
        size.getAndIncrement();
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        int location = hashCode%data.length;

        Node<K,V> obj = data[location];

        while (obj != null) {
            if(obj.k.equals(key)) {
                return obj.v;
            } else {
                obj = obj.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMapD<String, String> map = new HashMapD<>();
        map.put("1", "1");
        map.put("11", "11");
        map.put("2", "2");
        map.put("4", "2");

        System.out.println(map.get("1"));
        System.out.println(map.get("11"));
        System.out.println(map.get("2"));

    }
}


class Node<K,V> {
     K k;
     V v;
    Node next;

    public Node(K key, V val) {
        k = key;
        v = val;
    }
}