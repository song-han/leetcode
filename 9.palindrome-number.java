/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        List<Integer> list = new ArrayList<>();
        while(x != 0) {
            int num = x % 10;
            x = x / 10;
            list.add(num);
        }
        int start = 0;
        int end = list.size() - 1;
        while(end > start) {
            if (list.get(start) != list.get(end)) {
                return false;
            } else {
                start ++;
                end --;
            }
        }
        return true;
    }
}

