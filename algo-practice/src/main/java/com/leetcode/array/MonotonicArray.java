package com.leetcode.array;

/*An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.



Example 1:

Input: [1,2,2,3]
Output: true
* */
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        boolean flag = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (!(A[i] <= A[i + 1])) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            flag=true;
            for (int i = 0; i < A.length - 1; i++) {
                if (!(A[i] >= A[i + 1])) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new MonotonicArray().isMonotonic(new int[]{6,5,4,4}));

    }
}
