import javafx.util.Pair;
import java.util.*;

/*
Word Ladder
Given two words (beginWord and endWord), and a dictionary's word list,
Find the length of shortest transformation sequence from beginWord to endWord, such that:
1. only one letter can be changed at a time.
2. each transformed word must exist in the word list.
    Note that the beginWord is not a transformed word.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {
    /*
    Use beginWord and endWord as start node and end node of a graph.
    The intermediate nodes are determined by the wordList given to us.
    The only condition for every step is the current word should change by just one letter.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        // notice all words are of same length
        int L = beginWord.length();

        // create a dictionary to hold the combination of words that can be formed,
        // from any given word by changing one letter at a time.
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();

        wordList.forEach(word ->{
            for (int i = 0; i < L; i++){
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                ArrayList<String> transformation = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformation.add(word);
                allComboDict.put(newWord, transformation);
            }
        });

        // queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visisted = new HashMap<>();
        visisted.put(beginWord, true);

        while (!Q.isEmpty()){
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++){
                // intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())){
                    // find the end word
                    if (adjacentWord.equals(endWord)){
                        return level + 1;
                    }
                    // otherwise, add it to the BFS queue. And also mark it as visited
                    if (!visisted.containsKey(adjacentWord)){
                        visisted.put(adjacentWord, true);
                        Q.add(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
