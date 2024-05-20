package com.leetcode.extra;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * <p>
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * <p>
 * Given a string s containing only digits, return the number of ways to decode it.
 * <p>
 * The answer is guaranteed to fit in a 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {
    Integer[] dp;

    public int numDecodings(String s) {
        dp = new Integer[s.length() + 1];
        return numDecodings(s, 0);
    }

    private int numDecodings(String s, int curr) {
        int n = s.length();
        if (curr >= n) {
            return 1;
        }
        if (s.charAt(curr) == '0') {
            return dp[curr] = 0;
        }
        if (dp[curr] != null)
            return dp[curr];

        if (curr == n - 1) {
            return dp[curr] = 1;
        } else {
            int num = (s.charAt(curr) - '0') * 10 + (s.charAt(curr + 1) - '0');
            if (num <= 26) {
                return dp[curr] = numDecodings(s, curr + 2) + numDecodings(s, curr + 1);
            } else {
                return dp[curr] = numDecodings(s, curr + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("123"));
    }
}
