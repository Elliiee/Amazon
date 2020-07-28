import java.util.PriorityQueue;
import java.util.Queue;

public class ts1167MinCostToConnectSticks {
    public int connectSticks(int[] sticks){
        Queue<Integer> pq = new PriorityQueue<>();
        for (int s : sticks){
            pq.add(s);
        }
        int total = 0;
        while (pq.size() > 0){
            int temp = pq.poll() + pq.poll();
            pq.add(temp);
            total += temp;
        }
        return total;
    }
}
