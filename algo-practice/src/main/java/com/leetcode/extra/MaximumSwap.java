package com.leetcode.extra;

/*Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
8569
Explanation: No swap.
actual: 98368
expected: 98863

*/
public class MaximumSwap {
    public int maximumSwap(int num) {
        char arr[] = ("" + num).toCharArray();
        boolean flag = true;
        int maxIndex = 0;
        int temp = arr[0];
        int j = 1;
        int t2=0;
        int indexOne=0;
        int indexLast=0;
        for (int k = 0; k < arr.length; k++) {
            for (int i = k + 1; i < arr.length; i++) {
                if (arr[k] < arr[i]) {
                    char t = arr[k];
                    arr[k] = arr[i];
                    arr[i] = t;
                    break;
                }

            }
        }
        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSwap().maximumSwap(98368));
    }
}
