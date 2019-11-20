/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class Node {
    Node pre;
    Node next;
    int val;
    int key;
    public Node(int key, int value) {
        this.key = key;
        this.val = value;
    }
}

class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addToHead(node);
            return;
        }
        if (map.size() == capacity) {
            map.remove(tail.pre.key);
            remove(tail.pre);
        }
        Node node = new Node(key, value);
        addToHead(node);
        map.put(key, node);
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = node.next = null;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

