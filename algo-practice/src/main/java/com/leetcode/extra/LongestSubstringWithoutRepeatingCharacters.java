package com.leetcode.extra;

import java.util.BitSet;

/***
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int ret = 0, i = 0, j = 0;
        BitSet bs = new BitSet(128);
        while (i < s.length()) {
            int bit = s.charAt(i);
            while (bs.get(bit)) {
                int deleteBit = s.charAt(j++);
                bs.set(deleteBit, false);
            }
            bs.set(bit);
            ++i;
            if (ret < i - j) {
                ret = i - j;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbb"));
    }
}
