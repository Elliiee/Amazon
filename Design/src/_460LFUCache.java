import java.util.HashMap;
import java.util.LinkedHashSet;

public class _460LFUCache {
    private int min;
    private int capacity;
    private HashMap<Integer, Integer> keyToVal;
    private HashMap<Integer, Integer> keyToCount;
    private HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;

    public _460LFUCache(int capacity){
        this.capacity = capacity;
        this.min = -1;
        this.keyToCount = new HashMap<>();
        this.countToLRUKeys = new HashMap<>();
        this.keyToCount = new HashMap<>();
    }

    private void evict(int key){
        countToLRUKeys.get(min).remove(key);
        keyToVal.remove(key);
    }

    private void putCount(int key, int count){
        keyToCount.put(key, count);
        countToLRUKeys.computeIfAbsent(count, ignore -> new LinkedHashSet<>());
    }
}
