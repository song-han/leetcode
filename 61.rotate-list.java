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
        if (head == null) return head;
        ListNode h = head;
        int count = 0;
        while (h != null) {
            count++;
            h = h.next;
        }
        int step = count - k % count;
        if (step == count) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        // find tail
        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode newTail = dummy;
        while(step > 0) {
            step--;
            newTail = newTail.next;
        }
        System.out.println(newTail.val);
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = dummy.next;

        return newHead;
    }
}
// @lc code=end

