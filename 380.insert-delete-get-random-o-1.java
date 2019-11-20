/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {
    private int size = 0;
    private List<Integer> list;
    private Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        if (list.size() == size) {
            list.add(val);
        } else {
            list.set(size, val);
        }
        map.put(val, size);
        size++;
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.remove(val);
        if (idx != size - 1) {
            list.set(idx, list.get(size - 1));
            map.put(list.get(idx), idx);
        }
        
        size--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = new Random().nextInt(size);
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

