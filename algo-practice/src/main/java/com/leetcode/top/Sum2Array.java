package com.leetcode.top;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class Sum2Array {
    // time complexity is O(n) here
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> resultMap=new HashMap();
        for(int i=0;i<nums.length;i++){
            int currentVal=nums[i];
            int tempVal=target-currentVal;
            if(resultMap.containsKey(tempVal)){
                return new int[]{resultMap.get(tempVal),i};
            }
            resultMap.put(currentVal,i);

        }

        return new int[]{};
    }
    // brute force way time complexity is O(n2)
    public static int[] twoSum2nd(int[] nums, int target) {


        // two loop way
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{};
    }
    public static void main(String[] args) {
        System.out.println(twoSum2nd(new int[]{2,7,11,15},9));
    }
}
