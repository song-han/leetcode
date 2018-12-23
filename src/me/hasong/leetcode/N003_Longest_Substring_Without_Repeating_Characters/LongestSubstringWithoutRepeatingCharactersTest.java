package me.hasong.leetcode.N003_Longest_Substring_Without_Repeating_Characters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void testLengthOfLongestSubstring1() {
        LongestSubstringWithoutRepeatingCharacters1 lswrc = new LongestSubstringWithoutRepeatingCharacters1();
        assertEquals(3, lswrc.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lswrc.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lswrc.lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, lswrc.lengthOfLongestSubstring(""));
    }

}
