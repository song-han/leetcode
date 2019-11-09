/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        return solution1(tasks, n);
    }

    private int solution1(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> b - a
        );
        int[] freeMap = new int[n + 1];
        int m = tasks.length;
        int[] countMap = new int[26];
        for (int i = 0; i < m; i++) {
            char c = tasks[i];
            countMap[c - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (countMap[i] > 0) {
                pq.add(countMap[i]);
            }
        }
        int freeCount = 0;
        int i = 0;
        while (freeCount > 0 || !pq.isEmpty()) {
            int preInterval = i - n - 1;
            int freeSlot = i % (n + 1);
            if (preInterval >= 0) {
                int freeTask = freeMap[freeSlot];
                if (freeTask > 0) {
                    freeMap[freeSlot] = 0;
                    pq.add(freeTask);
                    freeCount--;
                }
            }
            if (!pq.isEmpty()) {
                int task = pq.remove() - 1;
                if (task > 0) {
                    freeMap[freeSlot] = task;
                    freeCount++;
                }
            }
            i++;
        }
        return i;
    }
}
// @lc code=end

