/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? pow(x, n) : pow(1/x, -n);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = pow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
// @lc code=end

