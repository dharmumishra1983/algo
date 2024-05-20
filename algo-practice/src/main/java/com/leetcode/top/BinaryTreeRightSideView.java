package com.leetcode.top;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode rm = queue.remove();

                if (rm != null) {
                    if (i == n - 1) {
                        resultList.add(rm.val);
                    }
                    if (rm.left != null) {
                        queue.add(rm.left);
                    }
                    if (rm.right != null) {
                        queue.add(rm.right);
                    }
                }

            }
        }
        return resultList;

    }


    public static void main(String[] args) {
        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(2);
        tn.left.right = new TreeNode(5);
        tn.right = new TreeNode(3);
        tn.right.right = new TreeNode(4);
        new BinaryTreeRightSideView().rightSideView(tn);


    }
}
