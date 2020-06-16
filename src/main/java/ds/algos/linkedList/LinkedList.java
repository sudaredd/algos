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

    public void println() {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.getVal() + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(3);
        linkedList.addLast(2);
        linkedList.addFirst(1);
        linkedList.println();
    }
}
