package com.leetcode.trie;

/**
 * AN: 208
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 * <p>
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings
 */
public class ImplementTriePrefixTree {
    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isEnd;
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public ImplementTriePrefixTree() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (temp.next[index] == null) temp.next[index] = new TrieNode();
            temp = temp.next[index];
        }
        temp.isEnd = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (temp.next[index] == null) return false;
            temp = temp.next[index];
        }
        return temp.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (temp.next[index] == null) return false;
            temp = temp.next[index];
        }
        return true;

    }

    public static void main(String[] args) {
        ImplementTriePrefixTree t= new ImplementTriePrefixTree();
        t.insert("apple");
        System.out.println(t.startsWith("app"));
    }
}
