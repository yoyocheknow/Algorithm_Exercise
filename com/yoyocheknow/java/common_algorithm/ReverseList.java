package common_algorithm;

import dataStructure.ListNode;

/**
 * 翻转List
 *
 * @author zhihua on 2020/11/15
 */
public class ReverseList {

    public  ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head){
        //递归的终止条件
        if(head==null || head.next==null){
            return head;
        }
        //递归，找到新的头节点
        ListNode newHead = reverseList1(head.next);
        //真正的翻转逻辑，head->head.next  ----->  head.next->head
        head.next.next=head;
        //翻转后的节点next置空
        head.next=null;
        return newHead;
    }
    public static void main(String []args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;

        ListNode newHead =new ReverseList().reverseList1(node1);
        while (newHead!=null){
            System.out.println(newHead.getVal());
            newHead=newHead.next;
        }

    }
}