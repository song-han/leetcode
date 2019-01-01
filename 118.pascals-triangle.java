/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start

// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


// In Pascal's triangle, each number is the sum of the two numbers directly above it.

// Example:

// Input: 5
// Output:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

class Solution {
    public List<List<Integer>> generate(int numRows) {
        return solution1(numRows);
    }

    private List<List<Integer>> solution1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> rowNums = new ArrayList<>();
            if (row == 0) {
                rowNums.add(1);
            } else {
                for (int i = 0; i <= row; i++) {
                    if (i == 0 || i == row) {
                        rowNums.add(1);
                    } else {
                        List<Integer> preRow = result.get(row - 1);
                        int value = preRow.get(i - 1) + preRow.get(i);
                        rowNums.add(value);
                    }
                }
            }
            result.add(rowNums);
        }
        return result;
    }
}
// @lc code=end

