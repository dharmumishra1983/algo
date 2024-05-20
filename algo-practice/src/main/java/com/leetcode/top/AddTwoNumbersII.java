package com.leetcode.top;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = getStack(l1);
        Stack<Integer> s2 = getStack(l2);
        int sum = 0;
        int carry = 0;
        ListNode temp = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            int totalSum = sum + carry;
            carry = totalSum / 10;
            int lastDigit = totalSum % 10;
            ListNode newNode = new ListNode(lastDigit);
            newNode.next = temp;
            temp = newNode;
            sum=0;

        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = temp;
            temp = newNode;
        }
        return temp;

    }

    public void printLinkedList(ListNode l) {
        while (l != null) {
            System.out.print(l.val);
            l=l.next;
        }
    }

    public Stack<Integer> getStack(ListNode ln) {
        Stack<Integer> resultStack = new Stack<>();
        while (null != ln) {
            resultStack.add(ln.val);
            ln = ln.next;
        }
        return resultStack;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbersII obj=new AddTwoNumbersII();
       ListNode res= obj.addTwoNumbers(l1,l2);
        obj.printLinkedList(res);

    }
}
