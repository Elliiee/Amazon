import java.util.LinkedHashMap;
import java.util.Map;

public class _146LRCCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public _146LRCCache(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;
        /*
        With that access order = true you specify that you want an "access-ordered" map, not an "insertion-ordered" map.
        This means that you will get the values in the order of access (least recently accessed first).
        This is used for LRU Cache.
         */
    }

    public int get(int key){
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        return size() > capacity;
    }
}
