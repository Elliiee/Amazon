public class _206ReverseLinkedList {
    // Approach 1 Recursion
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null)
            return head;

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    // Approach 2 Iteration
    public ListNode reverseListII(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
