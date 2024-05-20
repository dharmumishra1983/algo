package com.leetcode.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*Given an integer array nums, design an algorithm to randomly shuffle the array.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.


Example 1:

Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]*/
public class ShuffleAnArray {
    Random random;
    int[] arr;
    int[] temp;
    int min = 0;
    int max = 0;
    int[] nums;
    Random rand;

    public ShuffleAnArray(int[] nums) {
        arr = nums;
        temp = new int[nums.length];
        random = new Random(nums.length - 1);
        max = nums.length - 1;
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }
        this.nums = nums;
        rand = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        List<Integer> shuffled = new LinkedList<Integer>();
        for (int num : nums) {
            int index = rand.nextInt(shuffled.size() + 1);
            shuffled.add(index, num);
        }

        int[] result = new int[shuffled.size()];
        for (int i = 0; i < shuffled.size(); i++)
            result[i] = shuffled.get(i);
        return result;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset1() {
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle1() {
        int index = random.nextInt(max - min + 1) + min;
        int tempVal = arr[index];
        arr[index] = arr[min];
        arr[min] = tempVal;
        return arr;
    }

    public static void main(String[] args) {
        ShuffleAnArray obj = new ShuffleAnArray(new int[]{1, 2, 3});
        System.out.println(obj.shuffle());
        System.out.println(obj.reset());
        System.out.println(obj.shuffle());
    }
}

