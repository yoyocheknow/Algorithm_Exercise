package leetcode.Array;

import dataStructure.ListNode;

import java.util.List;

public class Remove_Nth_From_End {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(n>0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);


        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode result = new Remove_Nth_From_End().removeNthFromEnd(l1,2);
        while (result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
