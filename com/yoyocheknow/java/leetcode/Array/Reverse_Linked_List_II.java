package leetcode.Array;

import dataStructure.ListNode;

/**
 * 翻转链表II，翻转n到m位置的中间链表
 *
 * @author zhihua on 2021/1/28
 */
public class Reverse_Linked_List_II {
    /**
     * 非递归解法
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next=head;

        ListNode pre=dummy;
        int index = 1;

        while(index<m){
            head = head.next;
            pre=pre.next;
            index++;
        }
        //index到达m位置，开始将m-n之间的数据翻转
        ListNode start = head;
        ListNode end=head;
        for(int i=m;i<n && end!=null;i++){
            end=end.next;
        }
        //记录翻转后的尾巴
        ListNode nextTail = end.next;
        end.next=null;
        pre.next = reverse(start);
        //此时的start已经到了翻转链表的尾部
        start.next=nextTail;

        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        ListNode pre =null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur=next;
        }

        return pre;
    }

    /**
     * 递归解法
     */

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        //如果m=1，即翻转前n个节点。走特殊的递归逻辑
        if(m==1){
            return reverseTopN(head,n);
        }
        //递推公式：将拿到的链表翻转，然后返回翻转后的头节点
        ListNode between = reverseBetween1(head.next,m-1,n-1);
        head.next = between;
        return head;
    }
    //翻转链表的头n个节点
    ListNode topSuccessor = null;
    public ListNode reverseTopN(ListNode head,int n){
        if(n==1){
            topSuccessor = head.next;
            return head;
        }
        ListNode newHead = reverseTopN(head.next,n-1);
        head.next.next=head;
        head.next=topSuccessor;
        return newHead;
    }

    public static void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;

        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node3.next=node4;
        node4.next=node5;
        ListNode result = new Reverse_Linked_List_II().reverseBetween1(node1,2,4);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}