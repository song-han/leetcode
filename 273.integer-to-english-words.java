/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */

// @lc code=start
class Solution {
    private final String[] LESS_THAN_20 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    private final String[] TENS = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    private final String[] THOUSANDS = {"", "Thousand ", "Million ", "Billion "};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int temp = num;
        String word = "";
        int i = 0;
        while (temp > 0) {
            if (temp % 1000 > 0) {
                word = hundredsToWords(temp % 1000) + THOUSANDS[i] + word;
            }
            temp /= 1000;
            i++;
        }
        return word.trim();
    }
     
    private String hundredsToWords(int num) {
        if (num <= 19) {
            return LESS_THAN_20[num];
        }
        if (num < 100) {
            return TENS[num / 10] + LESS_THAN_20[num % 10];
        }        
        return hundredsToWords(num / 100) + "Hundred " + hundredsToWords(num % 100);
    }
}
// @lc code=end

