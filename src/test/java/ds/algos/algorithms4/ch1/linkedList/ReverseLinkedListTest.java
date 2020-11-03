package ds.algos.algorithms4.ch1.linkedList;

import ds.algos.linkedList.ListNode;
import ds.algos.linkedList.ReverseLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseLinkedListTest {

    @Test
    public void testReverse() {
        ListNode sixthNode = new ListNode(6);
        ListNode fifthNode = new ListNode(5, sixthNode);
        ListNode fourthNode = new ListNode(4, fifthNode);
        ListNode thirdNode = new ListNode(3, fourthNode);
        ListNode secondNode = new ListNode(2, thirdNode);
        ListNode firstNode = new ListNode(1, secondNode);
        Assertions.assertEquals(1, firstNode.getVal());
        ListNode reverse = new ReverseLinkedList().reverseList(firstNode);
        Assertions.assertEquals(6, reverse.getVal());
    }

    @Test
    public void testReverse_reverseList_practice() {
        ListNode sixthNode = new ListNode(6);
        ListNode fifthNode = new ListNode(5, sixthNode);
        ListNode fourthNode = new ListNode(4, fifthNode);
        ListNode thirdNode = new ListNode(3, fourthNode);
        ListNode secondNode = new ListNode(2, thirdNode);
        ListNode firstNode = new ListNode(1, secondNode);
        Assertions.assertEquals(1, firstNode.getVal());
        ListNode reverse = new ReverseLinkedList().reverseList_practice(firstNode);
        Assertions.assertEquals(6, reverse.getVal());
    }
}
