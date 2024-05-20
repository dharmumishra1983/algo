package com.leetcode.top;
/*
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.
Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]
 */

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null && t2 != null) {
            return t2;
        }
        if (t1 != null && t2 == null) {
            return t1;
        }
        TreeNode temp = new TreeNode(t1.val + t2.val);
        temp.left = mergeTrees(t1.left, t2.left);
        temp.right = mergeTrees(t1.right, t2.right);

        return temp;

    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        t1.left=new TreeNode(3);
        t1.right=new TreeNode(2);
        t1.left.left=new TreeNode(5);
        TreeNode t2=new TreeNode(2);
        t2.left=new TreeNode(1);
        t2.left.right=new TreeNode(5);
        t2.right=new TreeNode(3);
        t2.right.right=new TreeNode(5);
       TreeNode res= new MergeTwoBinaryTrees().mergeTrees(t1,t2);
        System.out.println(res);
    }
}
