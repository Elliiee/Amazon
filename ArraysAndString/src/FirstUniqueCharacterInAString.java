import java.util.HashMap;

/*
First Unique Character in a String
Given a string,
find the first non-repeating character in it and return it's index.
If it doesn't exist, return -1.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqueChar(String s){
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();

        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++){
            if (count.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
