import java.util.*;

public class _819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned){
        paragraph += ".";

        Set<String> banset = new HashSet<>();
        for (String word : banned)
            banset.add(word);

        Map<String, Integer> map = new HashMap<>();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()){
            if (Character.isLetter(c)){
                word.append(Character.toLowerCase(c));
            }
            else if (word.length() > 0){
                String finalword = word.toString();
                if (!banset.contains(finalword)){
                    map.put(finalword, map.getOrDefault(finalword, 0) + 1);
                    if (map.get(finalword) > ansfreq){
                        ans = finalword;
                        ansfreq = map.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }
        return ans;
    }

    public String mostCommonWordII(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        for (String w : words){
            if (!ban.contains(w)){
                count.put(w, count.getOrDefault(w, 0) + 1);
            }
        }
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public String mostCommonWordIII(String paragraph, String[] banned){
        // split paragraph
        String[] words = paragraph.toLowerCase().split(("\\W+"));

        // add banned words to set
        Set<String> set = new HashSet<>();
        for (String word : banned)
            set.add(word);

        // add paragraph words to hash map
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            if (!set.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // get the most frequent word
        int max = 0;
        String res = "";
        for (String s : map.keySet()){
            if (map.get(s) > max){
                max = map.get(s);
                res = s;
            }
        }
        return res;
    }
}
