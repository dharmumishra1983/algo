package com.leetcode.string;

import java.util.Arrays;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] a1 = s.toCharArray();
        char[] a2 = t.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
    }
}
