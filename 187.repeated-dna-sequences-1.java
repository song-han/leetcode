/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> subs = new HashSet<>();
        Set<String> repeatSubs = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('T', 2);
        map.put('G', 3);
        int len = s.length();
        int L = 10;
        int reset = ~(3 << 2 * L - 2);
        int hash = 0;
        for (int i = 0; i < len; i++) {
            if (i >= L) {
                hash &= reset;
            }
            int value = map.get(s.charAt(i));
            hash = (hash << 2) | value;
            if (i >= L - 1) {
                if (subs.contains(hash)) {
                    repeatSubs.add(s.substring(i - L + 1, i + 1));
                } else {
                    subs.add(hash);
                }
            }
        }
        return new ArrayList<String>(repeatSubs);
    }
}
// @lc code=end

