import java.util.*;

public class _23MergeKSortedLists {
    // Approach 1 Brute Force
    public ListNode mergeKListsI(ListNode[] lists){
        List<Integer> listAllNodesVal = new ArrayList<>();
        for (ListNode ln : lists){
            while (ln != null){
                listAllNodesVal.add(ln.val);
                ln = ln.next;
            }
        }

        Collections.sort(listAllNodesVal);

        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;

        for (int i : listAllNodesVal){
            ListNode node = new ListNode(i);
            currentNode.next = node;
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        return dummyHead.next;
    }

    // Approach 3 min heap
    public ListNode mergeKListsII(ListNode[] lists){
        if (lists==null || lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    //
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head=null;
        ListNode former=null;
        while (l1!=null&&l2!=null) {
            if (l1.val>l2.val) {
                if (former==null) former=l2; else former.next=l2;
                if (head==null) head=former; else former=former.next;
                l2=l2.next;
            } else {
                if (former==null) former=l1; else former.next=l1;
                if (head==null) head=former; else former=former.next;
                l1=l1.next;
            }
        }
        if (l2!=null) l1=l2;
        former.next=l1;
        return head;

    }

    public ListNode mergeKListsIII(List<ListNode> lists) {
        if (lists.size()==0) return null;
        if (lists.size()==1) return lists.get(0);
        if (lists.size()==2) return mergeTwoLists(lists.get(0), lists.get(1));
        return mergeTwoLists(mergeKListsIII(lists.subList(0, lists.size()/2)),
                mergeKListsIII(lists.subList(lists.size()/2, lists.size())));
    }
}
