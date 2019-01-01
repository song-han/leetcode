/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Node implements Comparable<Node>{
    int num;
    int count;
    Node(int num, int count) {
        this.num = num;
        this.count = count;
    }

    public int compareTo(Node node) {
        return this.count - node.count;
    }
}

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        return solution1(nums, k);
    }

    public List<Integer> solution1(int[] nums, int k) {
        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int num: nums) {
            if (!num2Count.containsKey(num)) {
                num2Count.put(num, 1);
            } else {
                num2Count.put(num, 1 + num2Count.get(num));
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(k);
        for (Map.Entry<Integer, Integer> entry: num2Count.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            if (pq.size() < k) {
                pq.add(node);
            } else {
                if (node.count > pq.peek().count) {
                    pq.poll();
                    pq.add(node);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (pq.size() > 0) {
            Node node = pq.poll();
            result.add(node.num);
        }
        return result;
    }
}
// @lc code=end

