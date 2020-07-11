public class _2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode pointer1 = l1, pointer2 = l2, currentNode = dummyhead;
        int carry = 0;
        while (pointer1 != null || pointer2 != null){
            int val1 = pointer1 != null ? pointer1.val : 0;
            int val2 = pointer2 != null ? pointer2.val : 0;
            int sum = carry + val1 + val2;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;

            if (pointer1 != null) pointer1 = pointer1.next;
            if (pointer2 != null) pointer2 = pointer2.next;
        }
        if (carry >0)
            currentNode.next = new ListNode(carry);
        return dummyhead.next;
    }
}
