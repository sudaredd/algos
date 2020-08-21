package ds.algos.linkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HasCycleTest {

    @Test
    void hasCycle_True() {

        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);
        first.next.next.next = new ListNode(7);
        first.next.next.next.next = new ListNode(8);
        first.next.next.next.next.next = first.next;
        Assertions.assertTrue(HasCycle.hasCycle(first));

    }

    @Test
    void hasCycle_False() {

        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);
        first.next.next.next = new ListNode(7);
        first.next.next.next.next = new ListNode(8);
        first.next.next.next.next.next = new ListNode(9);
        Assertions.assertFalse(HasCycle.hasCycle(first));

    }
}