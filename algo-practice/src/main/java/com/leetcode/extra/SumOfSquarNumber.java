package com.leetcode.extra;

/*
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.



Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:

Input: c = 3
Output: false
 */
public class SumOfSquarNumber {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int)Math.sqrt(c);
        int res = 0;
        while (i <= j) {
            res = (i * i) + (j * j);
            if (res == c) {
                return true;
            }
            if (res > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSquarNumber().judgeSquareSum(2));
    }
}
