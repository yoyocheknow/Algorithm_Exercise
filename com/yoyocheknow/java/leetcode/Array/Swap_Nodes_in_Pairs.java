package leetcode.Array;

import common_algorithm.ReverseList;
import dataStructure.ListNode;

public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }

        //定义一个假头节点
        ListNode dummy = new ListNode(0);
        //dummy->1->2->3->4->5
        dummy.next=head;
        //pre 每次指向要翻转链表头节点的上一个节点。end指向每次翻转链表的尾节点
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next!=null){
            //循环k次，找到要翻转链表的末尾。
            //dummy->1->2->3->4->5 ,若k=2,循环两次，此时end=2
            for(int i=0;i<2 && end!=null ;i++){
                end = end.next;
            }
            //如果end==null,说明已经到末尾了，不需要翻转了
            if(end==null){
                break;
            }
            //记录end.next，方便后面链接
            ListNode next = end.next;
            //断开链表
            end.next=null;
            //记录下要翻转链表的头节点
            ListNode start = pre.next;
            //进行翻转，pre.next=翻转后的头节点
            pre.next=reverse(start,2);
            //翻转后的链表头节点到了最后，然后把后面的链表链接起来
            start.next = next;
            //翻转完成后，pre节点=上面翻转后的尾节点
            pre=start;
            //end节点也是，=上面翻转后的尾节点
            end=start;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode head,int n){
        if(head==null){
            return null;
        }
        ListNode dummy = head;
        ListNode curr=head;
        //dummy节点一直往前走，走到下一次翻转的头节点即是dummy的初始值定义
        //dummy的定义是翻转链表前的末尾节点null
        //现在只翻转N个节点的话，那么dummy应该就是第N+1个节点
        for(int i=1;i<=n;i++){
            if(dummy!=null){
                dummy=dummy.next;
            }
        }
        while(curr!=null && n>0){
            ListNode nextNode = curr.next;
            curr.next = dummy;
            dummy=curr;
            curr=nextNode;
            n--;
        }
        return dummy;
    }
    public static void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode newHead =new Swap_Nodes_in_Pairs().swapPairs(node1);
        while (newHead!=null){
            System.out.println(newHead.getVal());
            newHead=newHead.next;
        }
    }
}
