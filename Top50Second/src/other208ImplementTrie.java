public class other208ImplementTrie {
    class TrieNode{
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }

        public TrieNode(char x){
            children = new TrieNode[26];
            isWord = false;
            val = x;
        }
    }

    private TrieNode root;

    public other208ImplementTrie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode(c);
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word){
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null)
                return false;
            cur = cur.children[c-'a'];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix){
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (cur.children[c-'a'] == null)
                return false;
            cur = cur.children[c-'a'];
        }
        return true;
    }
}
