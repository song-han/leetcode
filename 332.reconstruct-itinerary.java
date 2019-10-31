/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        
        for (List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!flights.containsKey(from)) {
                flights.put(from, new PriorityQueue<String>());
            }
            flights.get(from).add(to);
        }

        List<String> path = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.add("JFK");
        while(!stack.isEmpty()) {
            String top = stack.peek();
            while (flights.containsKey(top) && !flights.get(top).isEmpty()) {
                top = flights.get(top).remove();
                stack.push(top);
            }
            path.add(0, stack.pop());
        }   

        return path;
    }
}
// @lc code=end

