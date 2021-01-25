package leetcode.Array;

import dataStructure.ListNode;

/**
 * 链表是否有环II
 *
 * @author zhihua on 2021/1/25
 */
public class Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){ //找到环中的一个点
                slow=head;  //slow置为head节点，两个指针此时走同样的step
                while (slow.next !=fast.next){//如果不相同，那说明没有到环的开始节点
                    slow=slow.next;
                    fast=fast.next;
                }
                return fast.next;
            }
            if(fast==head){//防止这个头节点本身是一个环
                return head;
            }

        }
        return null;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l3;
        System.out.println(new Linked_List_Cycle_II().detectCycle(l1).val);
    }
}