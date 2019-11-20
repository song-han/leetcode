/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> notVisited = new HashSet<>(wordList);
        if (!notVisited.contains(endWord)) {
            return 0;
        }
        notVisited.remove(endWord);
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        int path = 2;
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (endSet.size() > beginSet.size()) {
                Set<String> set = endSet;
                endSet = beginSet;
                beginSet = set;
            }
            Set<String> nextSet = new HashSet<>();
            for (String s: beginSet) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        arr[i] = c;
                        String nextStr = String.valueOf(arr);
                        if (endSet.contains(nextStr)) {
                            return path;
                        }
                        if (notVisited.contains(nextStr)) {
                            notVisited.remove(nextStr);
                            nextSet.add(nextStr);
                        }
                    }
                    arr[i] = old;
                }
            }
            beginSet = nextSet;
            path++;
        }
        return 0;
    }
}
// @lc code=end

