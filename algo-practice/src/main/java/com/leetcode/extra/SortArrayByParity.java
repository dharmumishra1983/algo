package com.leetcode.extra;

/*Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.*/
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[j] % 2 == 0 && A[i] % 2 != 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;

            } else if ((A[i] != 0) && (A[j] % 2 == 0 && A[i] % 2 == 0)) {
                int temp = A[i + 1];
                A[i + 1] = A[j];
                A[j] = temp;
                i = i + 2;
            } else if (A[i] == 0) {
                i++;
            } else {
                j--;
            }
        }
        return A;

    }

    public static void main(String[] args) {
        new SortArrayByParity().sortArrayByParity(new int[]{0, 2, 1, 4});
    }
}
