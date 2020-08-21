package ds.algos.linkedList;

class MultilevelNode {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "MultilevelNode{" +
                "val=" + val +
                ", prev=" + prev +
                ", next=" + next +
                ", child=" + child +
                '}';
    }
}