class Solution {
    /**
     * Tree有两个性质：
     * 1. 没有环
     * 2. 所有node都连接在一起
     * 用BFS，保存所有访问过的点，如果发现下一个要遍历的点已经访问过，说明有有环。
     * 如果有的点没有被遍历过，说明没有连接起来
     */
    public boolean validTree(int n, int[][] edges) {
        // build graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge: edges) {
            int p1 = edge[0];
            int p2 = edge[1];
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int cur = queue.remove();
            if (visited.contains(cur)) {
                return false;
            } else {
                visited.add(cur);
            }
            for (int node: graph.get(cur)) {
                queue.add(node);
                graph.get(node).remove(cur);
            }
        }
        return visited.size() == n;
    }
}