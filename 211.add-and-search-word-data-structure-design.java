/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */

// @lc code=start
class TrieNode {

    private TrieNode[] links;
    private int SIZE = 26;
    private boolean isEnd = false;

    public TrieNode() {
        links = new TrieNode[SIZE];
    }

    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}

class WordDictionary {

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.containsKey(c)) {
                cur.put(c, new TrieNode());
            }
            cur = cur.get(c);
        }
        cur.setEnd();
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        int idx = 0;
        while(idx < word.length()) {
            if (queue.isEmpty()) {
                return false;
            }
            char c = word.charAt(idx);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TrieNode cur = queue.remove();
                if (c == '.') {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        TrieNode child = cur.get(ch);
                        if (child != null) {
                            queue.add(child);
                        }
                    }
                } else {
                    if (cur.containsKey(c)) {
                        queue.add(cur.get(c));
                    }
                }
            }
            idx++;
        }
        while (!queue.isEmpty()) {
            if(queue.remove().isEnd()) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

