package com.leetcode.tree;

import com.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.*/
public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        readTree(root1, result);
        readTree(root2, result);
        Collections.sort(result);
        return result;

    }

    public void readTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.left != null) {
            readTree(root.left, result);
        }
        if (root.right != null) {
            readTree(root.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(4);
        TreeNode t2=new TreeNode(1);
        t2.left = new TreeNode(0);
        t2.right = new TreeNode(3);
        System.out.println(new AllElementsInTwoBinarySearchTrees().getAllElements(t1, t2));
    }
}
