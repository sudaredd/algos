package ds.algos.amazon;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: false
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(2);
        root.next.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(root));
        System.out.println(isPalindromeWithoutStack(root));

        root = new ListNode(1);
        root.next = new ListNode(0);
        root.next.next = new ListNode(5);
        System.out.println(isPalindrome(root));
//        System.out.println(isPalindromeWithoutStack(root));
      System.out.println(reverse(root));
        printReverse(root);

//        System.out.println(isPalindrome(new ListNode(1)));
    }

    public static void printReverse(ListNode node) {

        if (node == null)
            return;
        printReverse(node.next);

        System.out.println(node.val);
    }

    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static boolean isPalindromeWithoutStack(ListNode head) {

        if (head.next == null)
            return true;

        ListNode slow = head;

        ListNode fast = head;

        //1 2 3 3 2 1
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static boolean isPalindrome(ListNode head) {

        if (head.next == null)
            return true;

        ListNode slow = head;

        ListNode fast = head;

        Deque<Integer> stack = new LinkedList<>();

        //1 2 3 3 2 1
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null && !stack.isEmpty()) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return stack.isEmpty();
    }
}
