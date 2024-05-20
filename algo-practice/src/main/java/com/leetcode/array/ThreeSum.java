package com.leetcode.array;
/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int number = nums[i];
            int f = i + 1;
            int r = nums.length - 1;
            while (f < r) {
                int total = number + nums[f] + nums[r];
                if (total == 0) {
                    List<Integer> list = Arrays.asList(nums[f], number, nums[r]);
                    result.add(list);
                    f++;
                    while (f < r && nums[f] == nums[f - 1]) {
                        f++;
                    }
                    r--;
                    while (f < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (total < 0) {
                    f++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
