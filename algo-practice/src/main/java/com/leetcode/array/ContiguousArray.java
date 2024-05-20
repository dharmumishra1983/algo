package com.leetcode.array;

import java.util.HashMap;

/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
* */
public class ContiguousArray {
    public int findMaxLength2(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            temp += nums[i] == 0 ? 1 : -1;
            if (map.containsKey(temp)) max = Math.max(max, i - map.get(temp));
            else map.put(temp, i);
        }

        return max;
    }

    //this is not covering all possible test case
    public int findMaxLength(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i] - nums[i + 1];
            if (temp == -1 || temp == 1) {
                ++max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new ContiguousArray().findMaxLength2(new int[]{0, 1, 0,1,0,0,1}));
    }
}
