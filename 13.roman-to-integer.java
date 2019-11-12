/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        // Note: roman number always write from left to right and large to small
        // 建立synmbol到value的mapping
        // 碰到V或者X就检测左边是不是I
        // 碰到其它的就累加
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            char cur = s.charAt(i);
            int value = map.get(cur);
            if (i < n - 1) {
                char pre = s.charAt(i + 1);
                int preValue = map.get(pre);
                if (value < preValue) {
                    num -= value;
                    continue;
                }
            }
            num += value;
        }
        return num;
    }
}
// @lc code=end

