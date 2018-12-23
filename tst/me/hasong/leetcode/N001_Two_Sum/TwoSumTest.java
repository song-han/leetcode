package me.hasong.leetcode.N001_Two_Sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TwoSumTest {

    @Test
    public void testTwoSum1() {
        int[] testCase = {1, 2, 3, 4, 5};
        int[] result = new TwoSum1().twoSum(testCase, 5);
        assertEquals(result[0], 0);
        assertEquals(result[1], 3);
    }

    @Test
    public void testTwoSum2()  {
        int[] testCase = {1, 2, 3, 4, 5};
        int[] result = new TwoSum2().twoSum(testCase, 5);
        assertEquals(result[0], 0);
        assertEquals(result[1], 3);
    }
}
