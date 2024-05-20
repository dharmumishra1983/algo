package com.leetcode.array;

import java.util.Arrays;

/*Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.



Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99*/
public class SingleNumberII {
    public static int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length - 3; i += 3) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            if (a == b && a == c && b == c) {
                continue;
            }
            if (a == b) {
                return c;
            }
            if (b == c) {
                return a;
            }
            return b;
        }
        return nums[nums.length - 1];
    }
    public static int singleNumber(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            flag=true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    flag=false;
                //break;
                }
                else if(!flag){
                    return nums[j] ;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[]{0,1,0,1,0,1,99}));
    }
}
