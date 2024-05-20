package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an initial array arr, every day you produce a new array using the array of the previous day.
 * <p>
 * On the i-th day, you do the following operations on the array of day i-1 to produce the array of day i:
 * <p>
 * If an element is smaller than both its left neighbor and its right neighbor, then this element is incremented.
 * If an element is bigger than both its left neighbor and its right neighbor, then this element is decremented.
 * The first and last elements never change.
 * After some days, the array does not change. Return that final array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [6,2,3,4]
 * Output: [6,3,3,4]
 * Explanation:
 * On the first day, the array is changed from [6,2,3,4] to [6,3,3,4].
 * No more operations can be done to this array.Given an initial array arr, every day you produce a new array using the array of the previous day.
 * <p>
 * On the i-th day, you do the following operations on the array of day i-1 to produce the array of day i:
 * <p>
 * If an element is smaller than both its left neighbor and its right neighbor, then this element is incremented.
 * If an element is bigger than both its left neighbor and its right neighbor, then this element is decremented.
 * The first and last elements never change.
 * After some days, the array does not change. Return that final array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [6,2,3,4]
 * Output: [6,3,3,4]
 * Explanation:
 * On the first day, the array is changed from [6,2,3,4] to [6,3,3,4].
 * No more operations can be done to this array.
 */

public class ArrayTransFormation {

    public List<Integer> transformArray(int[] arr) {
        boolean flag = true;
        int temp[] = arr.clone();
        while (flag) {
            flag = false;

            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    temp[i]++;
                    flag = true;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    temp[i]--;
                    flag = true;
                }
            }
            arr=temp;
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            resultList.add(arr[i]);
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayTransFormation().transformArray(new int[]{1,5,4,7,9,2,5,1,2,5,8,8,3,8,4,4,6,3}));
    }
}
