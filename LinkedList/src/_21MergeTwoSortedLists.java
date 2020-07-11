public class _21MergeTwoSortedLists {
    // Approach 1 Recursion
    public ListNode mergeTwoSortedListsI(ListNode l1, ListNode l2){
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val < l2.val){
            l1.next = mergeTwoSortedListsI(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoSortedListsI(l2.next, l1);
            return l2;
        }
    }

    // Approach 2 Iteration
    public ListNode mergeTwoSortedListsII(ListNode l1, ListNode l2){
        ListNode dummyhead = new ListNode(0);
        ListNode currentNode = dummyhead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                currentNode.next = l1;
                l1 = l1.next;
            }
            else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = l1 == null ? l2 : l1;
        return dummyhead.next;
    }
}
