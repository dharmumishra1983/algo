package com.leetcode.array;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Return the minimum element of this array.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
* */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i + 1] < nums[i]) {
                return nums[i+1];
            }
            if (nums[j - 1] > nums[j]) {
                return nums[j];
            }
            i++;
            j--;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(new int[]{2,2,2,0,1}));
    }
}
