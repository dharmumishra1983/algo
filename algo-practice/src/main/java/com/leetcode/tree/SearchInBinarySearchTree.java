package com.leetcode.tree;

import com.leetcode.linkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

/*
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example,

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2
     / \
    1   3
 */
public class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        Map<Integer, TreeNode> resultMap = new HashMap<>();
        search(root, val, resultMap);
        if (resultMap.containsKey(val)) {
            return resultMap.get(val);
        }
        return null;
    }

    public void search(TreeNode root, int val, Map<Integer, TreeNode> resultMap) {
        if (root == null) {
            return;
        }
        resultMap.put(root.val, root);
        if (root.left != null) {
            search(root.left, val, resultMap);
        }
        if (root.right != null) {
            search(root.right, val, resultMap);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(3);
        t1.right = new TreeNode(7);
        TreeNode t2 = new SearchInBinarySearchTree().searchBST(t1, 2);
        System.out.println(t2);

    }
}
