package com.leetcode.array;

/**
 * Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.
 * <p>
 * The returned array must be in sorted order.
 * <p>
 * Expected time complexity: O(n)
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
 * Output: [3,9,15,33]
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for (int i = 0; i < nums.length; i++) {
            int exp = a * nums[i] * nums[i] + b * nums[i] + c;
            if (i > 0) {
                int temp = nums[i - 1];
                if (temp > exp) {
                    shiftElement(i, nums, exp);
                } else {
                    nums[i] = exp;
                }
            } else {
                nums[i] = exp;
            }
        }
        return nums;
    }

    private int getIndexOfElement(int element, int lastIndex, int arr[]) {
        int i = lastIndex;
        while (i > 0) {
            if (arr[i] > element) {
                i--;
            } else {
                return i;
            }
        }
        return 0;
    }

    private void shiftElement(int lastIndex, int arr[], int element) {
        int i = lastIndex;
        int f = getIndexOfElement(element, lastIndex-1, arr);
        while (i > f) {
            arr[i] = arr[i - 1];
            i--;
        }
        arr[f] = element;
    }

    public static void main(String[] args) {
        new SortTransformedArray().sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5);
    }
}
