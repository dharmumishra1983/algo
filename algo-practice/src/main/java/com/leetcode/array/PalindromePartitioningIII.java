package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a string s containing lowercase letters and an integer k. You need to :

First, change some characters of s to other lowercase English letters.
Then divide s into k non-empty disjoint substrings such that each substring is palindrome.
Return the minimal number of characters that you need to change to divide the string.



Example 1:

Input: s = "abc", k = 2
Output: 1
Explanation: You can split the string into "ab" and "c", and change 1 character in "ab" to make it palindrome.
 */
public class PalindromePartitioningIII {
    public int palindromePartition(String s, int k) {
        int total = 0;
        List<String> subString = new ArrayList<>();
        int strLength = s.length();
        int totalSubString = strLength / k;
        int counter = 1;
        int index = 0;
        int lastIndex = 0;
        while (counter <= totalSubString) {
            lastIndex = index + k;
            subString.add(s.substring(index, lastIndex));
            index = index + k;
            counter++;
        }
        if (lastIndex < strLength) {
            subString.add(s.substring(lastIndex - 1, s.length() - 1));
        }
        //checking palindrom for all substring
        for (String str : subString) {
            if (checkPalindrom(str)) {
                ++total;
            }
        }
        return total;
    }

    public boolean checkPalindrom(String str) {
        int i = 0, j = str.length() - 1;
        if (str.length() == 1) {
            return false;
        }
        while (i < j) {
            if (str.charAt(i) != str.charAt(j - 1 - i))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningIII().palindromePartition("aabbc", 3));
    }
}
