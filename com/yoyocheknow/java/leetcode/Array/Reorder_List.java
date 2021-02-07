package leetcode.Array;

import dataStructure.ListNode;

/**
 * 链表重排序
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 思路：先将链表分成两半
 * 然后将后半截的链表翻转
 * 最后合并两个链表
 * @author zhihua on 2021/2/7
 */
public class Reorder_List {
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow =head;
        ListNode fast = head;
        ListNode pre = dummy;
        //将链表分为两端，pre为后半段链表的前指针
        while(fast!=null&& fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            pre=pre.next;
        }
        pre.next=null;

        //翻转后半截链表
        ListNode halfHead = reverse(slow);
        //合并两个链表
        while (head!=null && halfHead!=null){
            pre = head;
            //记录head的next节点
            ListNode next = head.next;
            //记录后半截head的next节点
            ListNode halfNext = halfHead.next;
            //后半截节点往前安排
            head.next = halfHead;
            halfHead.next = next;
            head = next;
            halfHead = halfNext;
            pre = pre.next;
        }
        //如果后半截比前半截多一个，用pre记录尾部节点，然后把后半截多余的字段追上去
        if(halfHead!=null){
            pre.next=halfHead;
        }

    }
    public ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        ListNode pre = null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
//        l5.next=l6;
        new Reorder_List().reorderList(l1);
        while (l1!=null){
            System.out.print(l1.val + " ");
            l1=l1.next;
        }
    }
}