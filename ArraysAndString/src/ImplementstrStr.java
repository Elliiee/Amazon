/*
Implement strStr()
Return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle){
        int l = needle.length(), n = haystack.length();

        for (int i = 0; i < n - l + 1; i++){
            if (haystack.substring(i, i + l).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
