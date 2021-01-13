package leetcode.Array;

import dataStructure.ListNode;

/**
 * 从有序的链表中删除重复节点
 *
 * @author zhihua on 2021/1/13
 */
public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy = head;
        ListNode pre = head;
        head = head.next;
        while (head!=null){
            if(head.val==pre.val){
                pre.next = head.next;
                head=head.next;
            }else{
                pre=pre.next;
                head=head.next;
            }
        }

        return dummy;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);

        l1.next=l2;
        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
        ListNode result = new Remove_Duplicates_from_Sorted_List().deleteDuplicates(l1);
        while (result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}