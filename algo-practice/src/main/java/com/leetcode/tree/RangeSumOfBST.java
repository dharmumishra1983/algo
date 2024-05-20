package com.leetcode.tree;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 */
public class RangeSumOfBST {
    static int sum = 0;

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return sum;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);
        return sum;

    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(10);
        treeNode.left=new TreeNode(5);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(7);
        treeNode.right=new TreeNode(15);
        treeNode.right.right=new TreeNode(18);
        System.out.println(rangeSumBST(treeNode,7,15));
    }

}
