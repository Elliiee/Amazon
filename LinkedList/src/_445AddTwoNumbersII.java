import java.util.Stack;

public class _445AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        ;
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode currentNode = new ListNode(0);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            currentNode.val = sum % 10;
            ListNode previousNode = new ListNode(sum / 10);
            previousNode.next = currentNode;
            currentNode = previousNode;
            sum /= 10;
        }
        return currentNode.val == 0 ? currentNode.next : currentNode;
    }
}
