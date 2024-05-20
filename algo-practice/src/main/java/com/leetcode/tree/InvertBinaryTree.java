package com.leetcode.tree;

/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        TreeNode res = new InvertBinaryTree().invertTree(treeNode);
        System.out.println(res);
    }
}
