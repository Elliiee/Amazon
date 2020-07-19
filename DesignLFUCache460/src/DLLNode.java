public class DLLNode {
    int key;
    int val;
    int frequency;
    DLLNode prev;
    DLLNode next;

    public DLLNode() {

    }

    public DLLNode(int key, int val){
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }

}
