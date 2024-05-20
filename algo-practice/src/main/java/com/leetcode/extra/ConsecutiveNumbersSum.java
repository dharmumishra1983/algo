package com.leetcode.extra;

/**
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * Example 2:
 * <p>
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * Example 3:
 * <p>
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 */
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int count = 0;

        int n = 1;
        int r = N;
        while (n <= N) {
            r -= (n - 1);
            if (r <= 0) break;
            if (r % n == 0) count++;
            n++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(5));
    }
}
