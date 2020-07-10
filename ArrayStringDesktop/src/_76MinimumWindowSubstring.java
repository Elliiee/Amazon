import java.util.HashMap;
import java.util.Map;

public class _76MinimumWindowSubstring {
    public String minWindow(String s, String t){
        if (s.length() == 0 || t.length() == 0){
            return "";
        }

        // hash map for all the unique characters' count in t
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // number of unique characters in t, which need to be present in the desired window
        int required = dictT.size();
        // left and right pointer
        int l = 0, r = 0;
        // formed is used to track how many unique characters in T have been found
        // in the current window with the required count matched
        int formed = 0;

        // hash map to count all the unique characters in the current window
        Map<Character, Integer> windowCounts = new HashMap<>();

        // ans list of the for (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()){
            // add one character from the right pointer to the window
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // if the count of the character in the current window equals the count required in T
            // increase formed
            if (dictT.containsKey(c) && windowCounts.get(c).equals(dictT.get(c))){
                formed++;
            }

            // contract the window until it's no longer contains all the characters in t
            while (l <= r && formed == required){
                c = s.charAt(l);
                // save the current minimum window
                if (ans[0] == -1 || r - l + 1 < ans[0]){
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // remove the character at the left pointer as part of the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()){
                    formed--;
                }

                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
