package common_algorithm;

import dataStructure.ListNode;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * 翻转List
 *
 * @author zhihua on 2020/11/15
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head){
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

    public static void main(String []args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;

        ListNode newHead =reverseList(node1);
        while (newHead!=null){
            System.out.println(newHead.getValue());
            newHead=newHead.next;
        }

    }
}