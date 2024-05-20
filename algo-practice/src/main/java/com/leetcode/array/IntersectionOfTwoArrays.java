package com.leetcode.array;


import java.util.ArrayList;
import java.util.List;

/*Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.*/
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (!l1.contains(nums1[i])) {
                        l1.add(nums1[i]);
                    }
                }
            }
        }
        int[] res = new int[l1.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = l1.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new IntersectionOfTwoArrays().intersection(new int[]{4, 9}, new int[]{4, 7, 9});
    }
}
