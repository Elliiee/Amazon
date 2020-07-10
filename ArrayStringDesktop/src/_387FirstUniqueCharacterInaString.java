import java.util.HashMap;

public class _387FirstUniqueCharacterInaString {
    public int firstUniqueChar(String s){
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < n; i++){
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
