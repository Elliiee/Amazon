import java.util.HashMap;
import java.util.Map;

class DLinkedNode{
    int val;
    int key;
    DLinkedNode prev;
    DLinkedNode next;
}

public class LRUCache {
    Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);

        if (node == null)
            return -1;

        moveToHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.val = value;
            newNode.key = key;
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }

        if(size > capacity){
            DLinkedNode tail = removeTail();
            cache.remove(tail.key);
            size--;
        }
        else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void addNode(DLinkedNode node){
        node.prev = head;
        node.next = tail;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
