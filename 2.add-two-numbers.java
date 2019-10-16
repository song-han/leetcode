/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

//linked-list | math

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return solution1(l1, l2);
        // int reminding = 0;
        // ListNode start  = new ListNode(0);
        // ListNode tail  =start;

        // while (l1 != null || l2 != null) {
        //     int n1 = l1 == null ? 0: l1.val;
        //     int n2 = l2 == null ? 0: l2.val;
        //     int num = reminding + n1 + n2;
        //     tail = tail.next = new ListNode(num % 10);
        //     reminding = num / 10;
        //     if (l1!=null)
        //         l1 = l1.next;
        //     if (l2!=null)
        //         l2 = l2.next;
        // }
        // if (reminding > 0)
        //     tail.next = new ListNode(reminding);
        // return start.next;
    }

    private ListNode solution1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int remainder = 0;
        while(l1 != null || l2 != null) {
            int sum = remainder;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            remainder = sum / 10;
            int value = sum % 10;
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        if (remainder > 0) {
            tail.next = new ListNode(remainder);
        }
        return head.next;
    }
}

