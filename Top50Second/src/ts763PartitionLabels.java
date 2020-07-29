import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ts763PartitionLabels {
    public List<Integer> partitionLabels(String S){
        if (S == null || S.length() == 0) return null;

        int[] map = new int[26];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++){
            map[S.charAt(i) - 'a'] = i;
        }

        int start = 0, last = 0;
        for (int i = 0; i < S.length(); i++){
            last = Math.max(last, S.charAt(i));
            if (last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
