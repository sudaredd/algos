package ds.algos.algorithms4.ch1.linkedList;

import ds.algos.linkedList.ListNode;
import ds.algos.linkedList.MiddleOfLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MiddleOfLinkedListTest {
    ListNode firstNode;

    @BeforeEach
    public void init() {
        ListNode sixthNode = new ListNode(6);
        ListNode fifthNode = new ListNode(5,sixthNode);
        ListNode fourthNode = new ListNode(4, fifthNode);
        ListNode thirdNode = new ListNode(3, fourthNode);
        ListNode secondNode = new ListNode(2, thirdNode);
        firstNode = new ListNode(1, secondNode);
    }

    @Test
    public void testMiddleItem() {
        MiddleOfLinkedList middle = new MiddleOfLinkedList();
        ListNode middleItem = middle.middleNode(firstNode);
        Assertions.assertNotNull(middleItem);
        Assertions.assertEquals(4, middleItem.getVal());
    }
}
