/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('T', 2);
        map.put('G', 3);

        Set<Integer> set = new HashSet<>();
        int L = 10;
        int len = s.length();
        int num = 0;
        Set<Integer> duplicate = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int v = map.get(c);

            if (i >= L) {
                int startIdx = i - L;
                int startV = map.get(s.charAt(startIdx)) * (int)Math.pow(4, L - 1);
                num -= startV;
            }
            num = num * 4 + v;
            if (i >= L - 1) {
                if (set.contains(num) && !duplicate.contains(num)) {
                    duplicate.add(num);
                    result.add(s.substring(i - L + 1, i + 1));
                } else {
                    set.add(num);
                }
            }
        }
        return result;
    }
}
// @lc code=end

