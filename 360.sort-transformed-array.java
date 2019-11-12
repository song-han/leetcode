// Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.

// The returned array must be in sorted order.

// Expected time complexity: O(n)

// Example 1:

// Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
// Output: [3,9,15,33]

// Example 2:

// Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
// Output: [-23,-5,1,7]


class Solution {
    // parabola
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] result = new int[n];
        if (n == 0) {
            return result;
        }
        int i = 0, j = n - 1;
        int start = 0, end = n - 1;
        while (i <= j) {
            int num1 = transform(a, b, c, nums[i]);
            int num2 = transform(a, b, c, nums[j]);
            if (a > 0) {
                if (num1 > num2) {
                    result[end--] = num1;
                    i++;
                } else {
                    result[end--] = num2;
                    j--;
                }
            } else {
                if (num1 < num2) {
                    result[start++] = num1;
                    i++;
                } else {
                    result[start++] = num2;
                    j--;
                }
            }
        }
        return result;
    }
    
    private int transform(int a, int b, int c, int num) {
        return a * num * num + b * num + c;
    }
}