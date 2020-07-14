public class _25ReverseNodesInKGroup {
    // Approach 1 Recursion
    public ListNode reverseKGroup(ListNode head, int k){
        int count = 0;
        ListNode currentPointer = head;
        while (count < k && currentPointer != null){
            currentPointer = currentPointer.next;
            count++;
        }
        if (count == k){
            ListNode reverseHead = reverseLinkedList(head, k);
            head.next  = reverseKGroup(currentPointer, k);
            return reverseHead;
        }
        return head;
    }

    public ListNode reverseLinkedList(ListNode head, int k){
        ListNode previousNode = null;
        ListNode currentNode = head;

        while (k > 0){
            ListNode nextNodeTmp = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNodeTmp;
            k--;
        }
        return previousNode;
    }
}
