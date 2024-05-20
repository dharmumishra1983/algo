package com.leetcode.array;

import java.util.HashSet;

/**
 * 4. Find Duplicates
 * Question​: Given an array of integers where each value 1 <= x <= len(array), write a
 * function that finds all the duplicates in the array.
 * here we find only one duplicate, we can find many and return array of result
 * 2. another approach first sort array and then compare with next element
 */
public class DuplicateElementsArrays {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> tempSet = new HashSet<>();
        for (int i : nums) {
            if (tempSet.contains(i)) {
                return i;
            } else {
                tempSet.add(i);
            }
        }
        return -1;

    }
}
