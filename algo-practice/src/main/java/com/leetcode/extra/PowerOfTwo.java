package com.leetcode.extra;

/*Given an integer n, write a function to determine if it is a power of two.



Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16*/
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (n % 2 != 0) {
            return false;
        }
        while (n > 0) {

            if (n == 2) {
                return true;
            } else {
                n = n / 2;
                if(n%2!=0){
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(5));
    }
}
