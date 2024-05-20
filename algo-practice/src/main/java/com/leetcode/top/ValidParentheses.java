package com.leetcode.top;

import java.util.HashMap;
import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
 */
public class ValidParentheses {
    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    public ValidParentheses() {
        this.mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> tempStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElm = tempStack.pop();
                if (topElm != this.mappings.get(c)) {
                    return false;
                }
            } else {
                tempStack.push(c);
            }
        }
        return tempStack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }
}
