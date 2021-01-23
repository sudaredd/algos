package ds.algos.amazon;

/**
 * // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * // Output: 7 -> 0 -> 8
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l = new ListNode(2);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);

        ListNode r = new ListNode(5);
        r.next = new ListNode(6);
        r.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l, r));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode currHead = listNode;

        int sum = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
             if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int rem = sum % 10;
            currHead.next = new ListNode(rem);
            currHead = currHead.next;

            sum = sum / 10;
        }
        if (sum == 1) {
            currHead.next = new ListNode(sum);
        }

        return listNode.next;
    }

}
