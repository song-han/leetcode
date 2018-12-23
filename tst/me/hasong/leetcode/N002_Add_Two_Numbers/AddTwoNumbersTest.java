package me.hasong.leetcode.N002_Add_Two_Numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTwoNumbersTest {

    @Test
    public void testAddTwoNumbers() {
        int[][][] testCases = {
                {
                    {2, 4, 3}, {5, 6, 4}, {7, 0, 8}
                },
                {
                    {0}, {0}, {0}
                },
                {
                    {1, 2, 3}, {0}, {1, 2, 3}
                },
                {
                    {1, 2, 3}, {1, 2}, {2, 4, 3}
                },
                {
                    {1, 2, 3}, {1, 8}, {2, 0, 4}
                },
                {
                    {1, 2, 3}, {1, 2, 7}, {2, 4, 0, 1}
                }
        };

        for (int[][] testCase: testCases) {
            test(testCase[0], testCase[1], testCase[2]);
        }

    }

    private void test(int[] input1, int[] input2, int[] correctList) {
        ListNode l1 = createList(input1);
        ListNode l2 = createList(input2);
        ListNode result = new AddTwoNumbers1().addTwoNumbers(l1, l2);
        // result: 7 -> 0 -> 8
        ListNode correctResult = createList(correctList);
        assertTrue(compareTwoLists(result, correctResult));
    }

    private ListNode createList(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int num: nums) {
            tail.next = new ListNode(num);
            tail = tail.next;
        }
        return head.next;
    }

    private boolean compareTwoLists(ListNode l1, ListNode l2) {
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val != l2.val) {
                    return false;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
