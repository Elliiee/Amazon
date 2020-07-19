import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private int capacity;
    private int size;
    private int minFrequency;
    private Map<Integer, DLLNode > cache;
    private Map<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key){
        DLLNode node = cache.get(key);

        if (node == null) return -1;

        updateNode(node);

        return node.val; // return the value of the node
    }

    public void put(int key, int value){
        //corner case
        if (capacity == 0)
            return;

        if (cache.containsKey(key)){
            DLLNode node = cache.get(key);
            node.val = value;
            updateNode(node);
        }
        else {
            size++;
            if (size > capacity){
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                DLLNode deleteNode = minFreqList.removeTail();
                cache.remove(deleteNode.key);
                size--;
            }
            // reset the min frequency to 1 because of adding a new node which has frequency = 1 for sure
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            // get the list with frequency = 1 or create a new list if there isn't one existing
            // and then add the node into the list, as well as cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    private void updateNode(DLLNode node){
        int curFreq = node.frequency; // get this node's frequency
        DoubleLinkedList curList = frequencyMap.get(curFreq); // get the list which the node locates
        curList.removeNode(node); // remove the node from the list because the frequency is increased by 1 now

        if (curFreq == minFrequency && curList.size == 0){ // if the current node's frequency is the min && list is empty
            minFrequency++; // min frequency has to increase by 1
        }

        node.frequency++; // node's frequency has to increase by 1

        DoubleLinkedList newList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList()); // create newList or get it from the map
        newList.addNode(node); // add the node to the new list
        frequencyMap.put(node.frequency, newList); // set the new list to the map
    }
}
