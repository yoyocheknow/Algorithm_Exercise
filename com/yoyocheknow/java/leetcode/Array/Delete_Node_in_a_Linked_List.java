package leetcode.Array;

import dataStructure.ListNode;

/**
 * 删除链表中的一个节点
 *
 * @author zhihua on 2021/2/24
 */
public class Delete_Node_in_a_Linked_List {
    public ListNode deleteNode(ListNode head,ListNode node) {
        if(head==null){
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode pre = dummy;
        ListNode current = head;
        if(head.val==node.val){
            dummy.next = head.next;
        }else{
            while (current.val!=node.val){
                current=current.next;
                pre = pre.next;
            }
            if(current.next!=null){
                pre.next=current.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        ListNode d = new Delete_Node_in_a_Linked_List().deleteNode(l1,new ListNode(3));
        while (d!=null){
            System.out.println(d.val);
            d=d.next;
        }
    }
}