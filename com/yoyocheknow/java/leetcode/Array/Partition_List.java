package leetcode.Array;

import dataStructure.ListNode;

/**
 * 分离链表,小于X的放在大于等于X的前面
 *
 * @author zhihua on 2021/1/14
 */
public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;
        while(head!=null){
            if(head.val<x){
                before.next = head;
                before=before.next;
            }else{
                after.next = head;
                after=after.next;
            }
            head = head.next;
        }
        after.next=null;
        before.next = after_head.next;
        return before_head.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);


        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;

        ListNode result = new Partition_List().partition(l1,3);
        while (result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}