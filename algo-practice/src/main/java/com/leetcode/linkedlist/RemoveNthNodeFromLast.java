package com.leetcode.linkedlist;


public class RemoveNthNodeFromLast {
    void printMiddle(ListNode head)
    {
        ListNode slow_ptr = head;
        ListNode fast_ptr = head;
        if (head != null)
        {
            while (fast_ptr != null && fast_ptr.next != null)
            {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                    slow_ptr.data + "] \n");
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        if(n==1&&head.next==null){
            return null;
        }
        ListNode f=head;
        ListNode s=head;
        for(int i=0;i<n;i++){
            if(s.next==null){
                if(i==n-1){
                    head=head.next;
                    return head;
                }

            }
            s=s.next;
        }
            while (s.next!=null){
                f=f.next;
                s=s.next;
            }
            f.next=f.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l=new ListNode(2);
        l.next=new ListNode(3);
        l.next.next=new ListNode(1);
        l.next.next.next=new ListNode(7);
        l.next.next.next.next=null;
        new RemoveNthNodeFromLast().printMiddle(l);
    }
}
