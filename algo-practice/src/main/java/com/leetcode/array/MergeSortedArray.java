package com.leetcode.array;

import java.util.Arrays;

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < nums1.length; i++) {

            if (n > -1) {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }

        Arrays.sort(nums1);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int result[] = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result[k] = nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            result[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            result[k] = nums2[j];
            j++;
            k++;
        }
        nums1 = result.clone();
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = new int[]{1, 2, 3, 0, 0, 0};
        int nums2[] = new int[]{2, 5, 6};
        new MergeSortedArray().merge2(nums1, 3, nums2, 3);
        System.out.println(nums1);
    }
}
