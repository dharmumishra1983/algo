package com.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 */
public class KthLargestElementArray {

    //this is one way to do this, another approach we can take using mapheap and minheap or can implemented quicksort
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list, Collections.reverseOrder());
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        System.out.println(new KthLargestElementArray().findKthLargest(new int[]{13, 7, 6, 45, 21, 9, 2, 100}, 1));
    }
}
