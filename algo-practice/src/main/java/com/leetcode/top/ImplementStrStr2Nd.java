package com.leetcode.top;

/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().



Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
 */
public class ImplementStrStr2Nd {
    int strStr(String haystack, String needle) {
        int n, m;
        n = haystack.length();
        m = needle.length();
        if (m == 0) return 0;

        for (int i = 0; i < n; i++) {
            if (i + m - 1 >= n) break;
            if (haystack.substring(i, m) == needle) return i;

        }
        return -1;
    }
        public static void main (String[]args){
            System.out.println(new ImplementStrStr2Nd().strStr("hello", "ll"));
        }
    }
