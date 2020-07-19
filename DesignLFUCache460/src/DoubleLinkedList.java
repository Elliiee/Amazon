public class DoubleLinkedList {
     int size;
     DLLNode head;
     DLLNode tail;

    public DoubleLinkedList(){
        this.size = 0;
        this.head = new DLLNode(0, 0);
        this.tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DLLNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;

        size++;
    }

    public void removeNode(DLLNode node){
        DLLNode prev = node.prev;
        DLLNode next = node.next;

        prev.next = next;
        next.prev = prev;

        size--;
    }

    public DLLNode removeTail(){
        if (size > 0){
            DLLNode res = tail.prev;
            removeNode(res);
            return res;
        }
        else {
            return null;
        }
    }
}
