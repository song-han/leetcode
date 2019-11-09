/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        Queue<ListNode> pq = new PriorityQueue<>(
            (p ,q) -> (p.val - q.val)
        );
        for (ListNode listNode: lists) {
            if (listNode != null) {
                pq.add(listNode);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.remove();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return head.next;
    }
}
// @lc code=end

