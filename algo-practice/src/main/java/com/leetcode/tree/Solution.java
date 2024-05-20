package com.leetcode.tree;

import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int Max = 0;
        for (int i = 0; i < prices.length-1; i++){
            if (prices[i+1] > prices[i]){
                Max += prices[i+1]-prices[i];
            }
        }
        return Max;
    }
    public boolean isValidBST(TreeNode root) {


        return checkValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkValid(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.val >= minValue && root.val < maxValue && checkValid(root.left, minValue, root.val) && checkValid(root.right, root.val, maxValue)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean find132pattern(int[] nums) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int num : nums) {
            tm.put(num, tm.getOrDefault(num, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int cnt = tm.get(num);
            if (cnt > 1) {
                tm.put(num, cnt - 1);
            } else {
                tm.remove(num);
            }
            if (num <= min) {
                min = num;
            } else {
                Integer target = tm.higherKey(min);
                if (target != null && target < num) {
                    return true;
                }
            }
        }
        return false;

    }

    public int twoSumLessThanK(int[] A, int K) {
        Map<Integer, Integer> treemap =
                new TreeMap<Integer, Integer>();
        int min = -1;
        int i = 0;
        int j = A.length - 1;
        int temp[] = A;
        Arrays.sort(temp);
        while (i < j) {
            if (temp[i] + temp[j] < K) {
                int diff = K - (temp[j] + temp[i]);
                treemap.put(diff, temp[i] + temp[j]);
                i++;
            } else {
                j--;
            }
        }
        if (treemap.size() > 0) {
            for (int t : treemap.keySet()) {
                return treemap.get(t);
            }
        }
        return -1;
    }

    public int firstMissingPositive(int[] nums) {
        int[] arr = new int[nums.length];
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            max = nums[i] > max ? nums[i] : max;
            if (nums[i] <= nums.length && nums[i] > 0)
                arr[nums[i] - 1] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1)
                return i + 1;
        }
        return max + 1;
    }

    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0) {
            if (target < nums[0]) {
                return 0;
            }
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;

        }
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return 0;

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String temp = strs[0];
        Arrays.sort(temp.toCharArray());

        String res = "";
        String tempStr = "";
        int count = 0;
        char[] chartTemp = temp.toCharArray();
        for (int i = 0; i < chartTemp.length; i++) {
            count = 0;
            res += chartTemp[i];
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].startsWith(res)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == strs.length) {
                tempStr = res;
            }

        }
        return tempStr;
    }

    public int reverse(int x) {
        int temp = x;
        long result = 0;
        while (temp != 0) {
            int remender = temp % 10;
            result = result * 10 + remender;
            temp = temp / 10;

        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        if (result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public boolean isPalindrome(int x) {
        int temp = x;
        int res = 0;
        while (temp > 0) {
            int remender = temp % 10;
            res = res * 10 + remender;
            temp = temp / 10;
        }
        if (res == x) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isBalanced(TreeNode root) {
        return root == null ? true : isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private int height(TreeNode root) {
        int val = root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
        return val;
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(1);
        t.right = new TreeNode(3);
        int[] arr = new int[]{254, 914, 110, 900, 147, 441, 209, 122, 571, 942, 136, 350, 160, 127, 178, 839, 201, 386, 462, 45, 735, 467, 153, 415, 875, 282, 204, 534, 639, 994, 284, 320, 865, 468, 1, 838, 275, 370, 295, 574, 309, 268, 415, 385, 786, 62, 359, 78, 854, 944, 200};
        System.out.println(new Solution().maxProfit(new int[]{10, 9, 8, 9, 10, 11, 9, 10}));
    }
}