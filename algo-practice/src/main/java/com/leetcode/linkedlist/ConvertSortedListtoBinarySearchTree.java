package com.leetcode.linkedlist;


import com.leetcode.tree.TreeNode;

/*
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 */
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.data);
        }
        return findRoot(head, null);
    }

    public TreeNode findRoot(ListNode head, ListNode rear) {
        if (head == rear) {
            return null;
        }
        if (head.next == rear) {
            return new TreeNode(head.data);
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != rear && fast.next != rear) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node;
        node = new TreeNode(slow.data);
        node.left = findRoot(head, slow);
        node.right = findRoot(slow.next, rear);
        return node;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(-13);
        listNode.next=new ListNode(-2);
        listNode.next.next=new ListNode(0);
        listNode.next.next.next=new ListNode(5);
        listNode.next.next.next.next=new ListNode(9);
       TreeNode tn= new ConvertSortedListtoBinarySearchTree().sortedListToBST(listNode);
        System.out.println(tn);
    }
}
