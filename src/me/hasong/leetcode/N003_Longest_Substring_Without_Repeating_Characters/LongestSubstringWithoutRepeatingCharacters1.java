package me.hasong.leetcode.N003_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters1 {
    /**
     * 有一个窗口从左到右移动，根据里面是否有重复的元素进行伸缩
     * 数据结构需要：
     * 1. 窗口的起始和终止位置
     * 2. 窗口里面的元素和数量
     * 3. 最大的长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null) {
            throw new IllegalArgumentException("");
        }

        int start = 0, end = 0;
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        while (end < s.length()) {
            char newChar = s.charAt(end);
            while (start < end && charMap.containsKey(newChar)) {
                char oldChar = s.charAt(start);
                int count = charMap.get(oldChar);
                if (count > 1) {
                    charMap.put(oldChar, count - 1);
                } else {
                    charMap.remove(oldChar);
                }
                start++;
            }
            charMap.put(newChar, 1);
            end++;
            int windowLength = end - start;
            maxLength = windowLength > maxLength ? windowLength : maxLength;
        }

        return maxLength;
    }

    /**
     * NOTE: 不需要记录字母在窗口中的出现次数，因为同样的字母只能出现一次。
     * 因此可以使用Set来记录某个字母是否在窗口中出现。
     *
     * 另一个改进的方面，可以用map记录字母最近出现的位置
     */

}
