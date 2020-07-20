import java.util.ArrayList;
import java.util.List;

public class am763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0)
            return null;

        int[] map = new int[26];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < S.length(); i++){
            map[S.charAt(i) - 'a'] = i;
        }

        int last = 0, start = 0;
        for (int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
