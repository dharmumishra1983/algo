package com.leetcode.extra;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        int lo = 0, hi = 0, length = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[j + 1])) {
                    dp[j] = true;
                    if (i - j + 1 > length) {
                        lo = j;
                        hi = i;
                        length = i - j + 1;
                    }
                } else {
                    dp[j] = false;
                }
            }
        }
        return s.substring(lo, hi + 1);
    }
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("abba"));
    }
}
