package com.leetcode.array;

import java.util.Arrays;

/*
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
* */
public class SquarOfSortedArray {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;

    }

    public static void main(String[] args) {
        new SquarOfSortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10});
    }
}
