package ds.algos.amazon;

//Given a linked list, determine if it has a cycle in it.
//Follow up:
//Can you solve it without using extra space?

/*  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }*/
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode root = new ListNode(10);
        ListNode first = new ListNode(20);
        ListNode second = new ListNode(30);
        ListNode third = new ListNode(40);
        root.next = first;
        first.next = second;
        second.next = third;
        third.next = first;
        System.out.println(hasCycle(root));
        third.next = null;
        System.out.println(hasCycle(root));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


}


