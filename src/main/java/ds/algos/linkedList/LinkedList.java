package ds.algos.linkedList;

class Node {
    private int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
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
    Node root;
    public void addFirst(int val) {
        Node node = new Node(val);
        if(root==null) {
            root = node;
            return;
        }
        node.next = root;
        root=node;
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

    public void addAt(int val, int pos) {
        Node node = new Node(val);
        Node first = root;
        pos--;
        while (--pos > 0) {
            first = first.next;
        }
        node.next=first.next;
        first.next=node;
    }

    public void addLast(int val) {
        Node node = new Node(val);
        if(root==null) {
            root = node;
            return;
        }
        Node temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void printReverse(Node node) {
        if(node == null)
            return;
        printReverse(node.next);
        System.out.print(node.getVal() + " ");
    }

    public void println() {
        print(root);
    }

    private void print(Node temp) {
        while (temp != null) {
            System.out.print(temp.getVal() + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.addLast(7);
        linkedList.println();
        linkedList.printReverse(linkedList.root);
        System.out.println();
        linkedList.addAt(10, 4);
        linkedList.println();
        Node reverse = linkedList.reverse(linkedList.root);
        linkedList.print(reverse);

    }
}
