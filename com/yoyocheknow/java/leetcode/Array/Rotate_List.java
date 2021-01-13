package leetcode.Array;

import dataStructure.ListNode;

/**
 * 旋转链表
 *
 * @author zhihua on 2021/1/13
 */
public class Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int length =0;
        ListNode firstHead =head;
        while(firstHead!=null){
            firstHead = firstHead.next;
            length++;
        }
        ListNode tail =head;
        ListNode dummy = head;
        k = k % length;
        if(k>0){
            while(k>0){
                tail = tail.next;
                k--;
            }
            while(tail.next!=null){
                tail = tail.next;
                head = head.next;
            }
            ListNode newHead = head.next;

            tail.next = dummy;
            head.next = null;

            return newHead;
        }else{
            return head;
        }

    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next=l2;
        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
        ListNode result = new Rotate_List().rotateRight(l1,4);
       while (result!=null){
           System.out.print(result.val + " ");
           result = result.next;
       }
    }
}