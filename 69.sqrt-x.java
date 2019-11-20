/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
// @lc code=end

