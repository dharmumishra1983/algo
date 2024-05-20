package com.leetcode.array;
/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        List<Integer> resultList = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            resultList.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            resultList.add(nums2[i]);
        }
        Collections.sort(resultList);
        int len = resultList.size();
        if (len % 2 == 0) {
            res = (double) (resultList.get(len / 2) + resultList.get(len / 2 - 1)) / 2;
        } else {
            res = resultList.get(len / 2);
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }
}
