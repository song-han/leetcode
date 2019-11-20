/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        int count = 1;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        tail.next = head;
        int rotation = count - k % count;
        while (rotation > 0) {
            head = head.next;
            tail = tail.next;
            rotation--;
        }
        tail.next = null;
        return head;
    }
}
// @lc code=end

