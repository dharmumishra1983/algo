package com.leetcode.top;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet();
        return helper(s, wordDict, dictionary);
    }

    private boolean helper(String s, List<String> wordDict, Set<String> dictionary) {
        if (s.length() == 0)
            return true;

        if (dictionary.contains(s))
            return false;

        for (String word : wordDict) {
            if (s.startsWith(word) && helper(s.substring(word.length(), s.length()), wordDict, dictionary))
                return true;
        }

        dictionary.add(s);
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        new WordBreak().wordBreak("catsandog", wordDict);
    }
}
