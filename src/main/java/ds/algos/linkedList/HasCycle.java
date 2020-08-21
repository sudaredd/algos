package ds.algos.linkedList;

public class HasCycle {

    public static boolean hasCycle(ListNode listNode) {

        if(listNode==null || listNode.next==null)
            return false;

        ListNode slow = listNode;
        ListNode fast = listNode.next.next;
        while (fast !=  null && fast.next != null) {
            if(slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
