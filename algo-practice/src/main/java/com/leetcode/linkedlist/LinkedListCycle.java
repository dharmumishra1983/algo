package com.leetcode.linkedlist;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(-2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head;
        System.out.println(new LinkedListCycle().hasCycle(head));
    }
}
