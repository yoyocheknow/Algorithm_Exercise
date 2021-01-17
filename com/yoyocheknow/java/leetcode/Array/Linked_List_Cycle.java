package leetcode.Array;

import dataStructure.ListNode;

/**
 * 链表是否有环
 *
 * @author zhihua on 2021/1/17
 */
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = slow.next;

        while (slow!=null && fast!=null){
            if(slow==fast){
                return true;
            }else if (fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }else{
                return false;
            }

        }
        return false;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);

        l1.next=l2;
        //l2.next=l1;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l2;
        System.out.println(new Linked_List_Cycle().hasCycle(l1));
    }
}