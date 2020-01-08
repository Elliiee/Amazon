import java.util.*;

/*
Group Anagrams
Given an array of strings, group anagrams together.
Note:
All inputs will be in lowercase.
The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        if (strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List> ans = new HashMap<>();

        for (String s : strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);

            String key = String.valueOf(ca);

            if (!ans.containsKey(key)){
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}
