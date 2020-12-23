package leetcode.Array;

import dataStructure.ListNode;

/**
 * 反转链表中的K组节点
 *
 * @author zhihua on 2020/12/23
 */
public class Reverse_Nodes_in_kGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //newHead 记录第一个k翻转后的头部
        ListNode newHead = head;
        int n=k;
        while(n>1 && newHead!=null){
            newHead = newHead.next;
            n--;
        }
        newHead = newHead!=null? newHead:head;
        ListNode lastTail=null;
        while (tryK(head,k)){
            //currentTail翻转k个节点后的 尾部
            //currentHead翻转k个节点后的 头部
            //nextHead 下一次翻转的头部
            ListNode[] listNodes = reverse(head,k);
            ListNode currentHead=listNodes[0];
            ListNode nextHead = listNodes[1];
            ListNode currentTail = listNodes[2];
            if(lastTail!=null){
                //如果有上一步翻转后的尾部，那么上一次翻转后的尾部 next指向本次翻转后的头部
                lastTail.next = currentHead;
            }

            lastTail=currentTail;
            //current_tail.next 指向下一次翻转前的头部（如果没有下一次翻转），如果还有下一次翻转的话，上面的if last_tail 就会更新
            currentTail.next=nextHead;
            head=nextHead;
        }
        return newHead;
    }
    //是否可以翻转K个节点
    public Boolean tryK(ListNode head,int k){
        while (head!=null && k>0){
            head= head.next;
            k--;
        }
        if(k==0){
            return true;
        }else
            return false;
    }

    public ListNode[] reverse(ListNode head,int k){
        ListNode pre=null;
        ListNode cur=head;
        int i=0;
        while(cur!=null && i<k){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
            i++;
        }
        ListNode currentHead = pre;
        //不足K个的元素不翻转，保证了nextHead 不会为null
        ListNode nextHead = cur;
        ListNode currentTail = head;
        return new ListNode[]{currentHead,nextHead,currentTail};
    }

    public static void main(String[]args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;

        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node3.next=node4;
        node4.next=node5;
        ListNode result = new Reverse_Nodes_in_kGroup().reverseKGroup(node1,2);
        while (result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }
}