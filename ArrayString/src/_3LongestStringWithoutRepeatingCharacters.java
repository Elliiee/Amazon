import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3LongestStringWithoutRepeatingCharacters {
    // Approach 1 Brute Force
    // O(n*n*n); O(min(n,m))
    public int lengthOfLongestSubstring(String s){
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j <= n; j++){
                if (allUnique(s, i, j))
                    ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++){
            Character ch = s.charAt(i);
            if (set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

    // Approach 2 Sliding Window
    public int lengthOfLongestSubstringII(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n){
            // try to extend the range
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // Approach 3 Sliding Window Optimized
    public int lengthOfLongestSubstringIII(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of the character
        // try to extend the range
        for (int j = 0, i = 0; j < n; j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
