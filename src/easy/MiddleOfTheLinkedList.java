package easy;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        int mid = length / 2;

        while (mid-- > 0) {
            head = head.next;
        }
        return head;
    }

    public ListNode middleNodeFastAndSlow(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
