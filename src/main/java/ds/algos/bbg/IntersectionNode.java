package ds.algos.bbg;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class IntersectionNode {

    public static void main(String[] args) {

        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(1);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);

        headB.next.next.next = common;

        System.out.println(getIntersectionNode(headA, headB));



    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode ha = headA;
        ListNode hb = headB;

        int aLength = 0;

        while (ha != null) {
            aLength++;
            ha = ha.next;
        }
        int bLength = 0;

        while (hb != null) {
            bLength++;
            hb = hb.next;
        }

        if (aLength > bLength) {
            int diff = aLength - bLength;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else if (bLength > aLength) {
            int diff = bLength - aLength;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;

    }

}
