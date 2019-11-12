/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> qp = new PriorityQueue<>(
            (a, b) -> {
                return (-a[0]*a[0] - a[1]*a[1] + b[0]*b[0] + b[1]*b[1]);
            }
        );
        for (int i = 0; i < points.length; i++) {
            qp.add(points[i]);
            if (qp.size() > K) {
                qp.remove();
            }
        }
        int[][] results = new int[K][2];
        
        int i=0;
        for (int[] point: qp) {
            results[i++] = point;
        }
        return results;
    }

}
// @lc code=end

