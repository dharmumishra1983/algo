package com.leetcode.linkedlist;
/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 */
public class IntersectionofTwoLinkedLists {
    public static int length(ListNode head)
    {
        int count=1;
        while(head!=null)
        {
            count++;
            head=head.next;
        }
        return count;
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1=length(headA);
        int l2=length(headB);
        if(l1>l2)
        {
            for(int i=0;i<(l1-l2);i++)
            {
                headA=headA.next;
            }
        }
        else
        {
            for(int i=0;i<(l2-l1);i++)
            {
                headB=headB.next;
            }
        }
        while(headA!=null && headB!=null)
        {
            if(headA==headB)
            {
                return headA;
            }
            else
            {
                headA=headA.next;
                headB=headB.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = new ListNode(8);
        listA.next.next.next = new ListNode(4);
        listA.next.next.next.next = new ListNode(5);
        listA.next.next.next.next.next = null;
        ListNode listB = new ListNode(5);
        listB.next = new ListNode(6);
        listB.next.next = new ListNode(1);
        listB.next.next.next =listA.next.next;
        listB.next.next.next.next = listA.next.next.next;
        listB.next.next.next.next.next =listA.next.next.next.next;
        listB.next.next.next.next.next.next = listA.next.next.next.next.next;
        ListNode res=getIntersectionNode(listA, listB);
        System.out.println("done!!"+res);
    }
}
