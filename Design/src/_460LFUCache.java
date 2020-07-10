import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class _460LFUCache {

    private HashMap<Integer, Integer> keyToVal;
    private HashMap<Integer, Integer> keyToCount;
    private HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;
    private int capacity;
    private int min;

    public _460LFUCache(int capacity){
        this.min = -1;
        this.capacity = capacity;
        this.keyToVal = new HashMap<>();
        this.keyToCount = new HashMap<>();
        this.countToLRUKeys = new HashMap<>();
    }

    public int get(int key){
        if (!keyToVal.containsKey(key))
            return -1;

        int count = keyToCount.get(key);
        //remove key from the current count since we will increase the count.
        countToLRUKeys.get(count).remove(key);

        // if there is nothing in the current min bucket
        if (count == min && countToLRUKeys.get(count).size() == 0)
            min++;

        putCount(key, count + 1); // removed it just now and add it back

        return keyToCount.get(key);
    }

    public void put(int key, int value){
        if (capacity <= 0) return;

        if (keyToVal.containsKey(key)){
            keyToVal.put(key, value); // update key's value
            get(key); // update key's count
            return;
        }

        // evict LRU from this min count bucket
        if (keyToVal.size() >= capacity){
            evict(countToLRUKeys.get(min).iterator().next());
        }

        min = 1;
        putCount(key, min); // adding new key and count
        keyToVal.put(key, value); // adding new key and value
    }

    private void evict(int key){
        countToLRUKeys.get(min).remove(key);
        keyToVal.remove(key);
    }

    private void putCount(int key, int count){
        keyToCount.put(key, count);
        countToLRUKeys.computeIfAbsent(count, ignore -> new LinkedHashSet<>());
        countToLRUKeys.get(count).add(key);
    }
}
