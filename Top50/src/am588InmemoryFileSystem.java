import java.util.*;

public class am588InmemoryFileSystem {

    class Node{
        int type = 0; // 1 - dir; 2 - file
        StringBuilder content;
        Node[] children = new Node[27];
    }

    Node root;

    public am588InmemoryFileSystem(){
        root = new Node();
        root.type = 1;
        root.children[26] = new Node();
    }
}
