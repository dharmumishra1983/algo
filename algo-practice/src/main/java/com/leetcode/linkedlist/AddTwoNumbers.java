package com.leetcode.linkedlist;

/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
* */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode r = res;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.data;
            }
            if (l2 != null) {
                b = l2.data;
            }
            int val = a + b + temp;
            res.next = new ListNode(val % 10);
            temp = val / 10;
            res = res.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return r.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        l1.next.next.next=null;
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        l2.next.next.next=null;
        new AddTwoNumbers().addTwoNumbers(l1,l2);
    }
}
