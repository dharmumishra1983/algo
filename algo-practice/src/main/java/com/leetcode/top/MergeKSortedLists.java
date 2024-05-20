package com.leetcode.top;

import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list.val);
                list = list.next;
            }
        }
        if (queue.isEmpty()) return null;
        ListNode head = new ListNode(queue.poll());
        ListNode temp = head;
        while (!queue.isEmpty()) {
            ListNode t = new ListNode(queue.poll());
            temp.next = t;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] list = new ListNode[]{l1, l2, l3};
        System.out.println(new MergeKSortedLists().mergeKLists(list));
    }
}
