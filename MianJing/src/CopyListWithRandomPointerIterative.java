import java.util.HashMap;

public class CopyListWithRandomPointerIterative {
    HashMap<Node, Node> visited = new HashMap<>();

    public Node getClonedNode(Node node){
        if (node != null){ // check the node if it's valid
            if (this.visited.containsKey(node)){
                return this.visited.get(node); // return the new node if it's in the dictionary
            } else {
                this.visited.put(node, new Node(node.val, null, null)); // add it to the dictionary
                return this.visited.get(node); // return the node
            }
        }
        return null;
    }

    public Node copyRandomList(Node head){
        if (head == null) return null;

        Node oldNode = head;

        Node newNode = new Node(oldNode.val, null, null);
        this.visited.put(oldNode, newNode);

        while (oldNode != null){
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }
}
