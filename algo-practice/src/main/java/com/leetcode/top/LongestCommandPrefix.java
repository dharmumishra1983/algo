package com.leetcode.top;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
 */
public class LongestCommandPrefix {
    // time complexity is O(N)square
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String temp = strs[0];
        String res = "";
        String tempStr = "";
        int count = 0;
        char[] chartTemp = temp.toCharArray();
        for (int i = 0; i < chartTemp.length; i++) {
            count=0;
            res += chartTemp[i];
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].startsWith(res)) {
                    count++;
                } else {
                    break;
                }
            }
            if(count==strs.length){
                tempStr=res;
            }

        }
        return tempStr;
    }
    //Time complexity : O(S)O(S) , where S is the sum of all characters in all strings.
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"flower","flow","flight"}));
    }
}
