import java.util.*;

public class ts692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k){
        Map<String, Integer> map = new HashMap<>();
        for (String w : words){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int f1 = map.get(o1);
                int f2 = map.get(o2);
                if (f1 == f2) return o2.compareTo(o1);
                return f1 - f2;
            }
        });

        for (String s : map.keySet()){
            pq.add(s);
            if (pq.size() > k)
                pq.poll();
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty())
            result.add(pq.poll());
        Collections.reverse(result);
        return result;
    }
}
