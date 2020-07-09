public class _28ImplementStrStr {
    // Approach 1 Substring: Linear Time Slice, fixed window length
    public int strStr(String haystack, String needle){
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++){
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    // Approach 2
    /*
    approach 1 compares the fixed length of substring one by one.
    approach 2 first try to find the first matched character.
    And then compare each of the character.
    If it doesn't match all the character, jump to the next unvisited position since the previous nodes already
    visited.
     */
    public int strStrII(String haystack, String needle){
        int l = needle.length(), n = haystack.length();
        if (l == 0) return 0;

        int pn = 0;
        while (pn < n - l + 1){
            while (pn < n - l + 1 && haystack.charAt(pn) != needle.charAt(0)) // !!
                pn++;

            int currentLength = 0, pl = 0;
            while (pl < l && pn < n && haystack.charAt(pn) == needle.charAt(pl)){
                pn++;
                pl++;
                currentLength++;
            }

            if (currentLength == l)
                return pn - l; // find the first match

            pn = pn - currentLength + 1;
        }
        return -1;
    }

    // Approach 3 Rabin-Karp Rolling Hash
    public int charToInt(int idx, String s){
        return (int)s.charAt(idx) - (int)'a';
    }


}
