import java.util.HashMap;
import java.util.Map;

public class _138CopyListWithRandomPointer {
    // Approach 1 Recursion
    public Node copyRandomList(Node head){
        Map<Node, Node> visited = new HashMap<>();

        if (head == null)
            return null;

        if (visited.containsKey(head))
            return visited.get(head);

        Node node = new Node(head.val, null, null);

        visited.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    // Approach 2 Iterative
    Map<Node, Node> visitedMap = new HashMap<>();

    public Node getClonedNode(Node node){
        if (node != null){
            if (visitedMap.containsKey(node)){
                return visitedMap.get(node);
            }
            else{
                visitedMap.put(node, new Node(node.val, null, null));
                return visitedMap.get(node);
            }
        }
        return null;
    }

    public Node copyRandomListII(Node head){
        if (head == null)
            return null;

        Node oldNode = head;

        Node newNode = new Node(oldNode.val, null, null);
        visitedMap.put(oldNode, newNode);

        while (oldNode != null){
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return visitedMap.get(head);
    }

    // Approach 3 Iterative with O(1) space

}
