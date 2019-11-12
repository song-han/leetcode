/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 1) return points.length;
        int n = points.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int count = 0;
            int same = 0;
            for (int j = i + 1; j < n; j++) {
                int a = points[i][0] - points[j][0];
                int b = points[i][1] - points[j][1];
                if (a == 0 && b == 0) {
                    same++;
                    continue;
                }

                String key = "";
                if (a == 0) {
                    key = "0-";
                } else if (b == 0) {
                    key = "-0";
                } else {
                    int d = gcd(a,b);
                    key = String.valueOf(a / d) + "-" + String.valueOf(b / d);
                }

                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
                
                count = Math.max(count, map.get(key));
            }
            max = Math.max(max, count + same + 1);
        }
        return max;
    }

    /**
        Calculate greatest common dividor
        time complexity: log(min(a, b))

        gcd(a, 0) = a
        gcd(a, b) = gcd(b, a mod b);
     */
    private int gcd(int a, int b) {
        int r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
// @lc code=end

