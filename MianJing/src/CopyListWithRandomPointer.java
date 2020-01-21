import java.util.HashMap;

/*
Since there are maybe cycle, we need to keep track of the visited/ copied nodes.
Recursion
 */
public class CopyListWithRandomPointer {
    // HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<Node, Node> visitedHash = new HashMap<>();

    public Node copyRandomList(Node head){
        if (head == null) return null;

        if (this.visitedHash.containsKey(head))
            return this.visitedHash.get(head); // if it's visited simply return the new node.

        // create a new node with the same value first
        Node node = new Node(head.val, null, null);

        // save it in the hash map to avoid a loop
        this.visitedHash.put(head, node);

        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}
