package ds.algos.practice;

class Node<T> {
    T val;
    Node next;

    public Node(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
            "val=" + val +
            ", next=" + next +
            '}';
    }
}

public class LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);
        linkedList.add(3);
        linkedList.add(9);
        System.out.println(linkedList.root);
        linkedList.remove(5);
        System.out.println("after delete::" + linkedList.root);
        linkedList.printReverse(linkedList.root);
        System.out.println(linkedList.reverse(linkedList.root));
    }

    Node<Integer> root;
    Node moving;

    public void add(int val) {
        Node node = new Node(val);
        if (root == null) {
            moving = root = node;
            return;
        }
        moving.next = node;
        moving = moving.next;
    }

    public void remove(int val) {

        if (root != null && root.val == val) {
            root = root.next;
            return;
        }

        Node<Integer> current = root;

        Node prev = current;

        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
                break;
            }
            prev = current;
            current = current.next;

        }

    }

    public Node reverse(Node node) {
        Node prev = null;
        Node current = node;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void printReverse(Node node) {
        if (node == null)
            return;
        printReverse(node.next);
        System.out.println(node.val);
    }
}
