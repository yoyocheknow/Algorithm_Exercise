package leetcode.Array;

import dataStructure.ListNode;

/**
 * 链表奇数位置递增，偶数位置递减，使之整体有序
 * 要求空间复杂度O(1),时间复杂度O(n)
 * 思路：
 * 1，将奇数位置，偶数位置链表分开
 * 2，偶数位置链表翻转
 * 3，合并两个有序链表
 * @author zhihua on 2021/1/5
 */
public class Odd_Even_Linked_List {
    public ListNode solution(ListNode head){
        ListNode head1=null;
        ListNode head2=null;
        ListNode cur1=null;
        ListNode cur2=null;
        int count =1;
        while(head!=null){
            if(count%2!=0){
               if(cur1==null){ //初始化奇数链表
                   cur1 = head;
                   head1 = cur1;
               }else{
                   cur1.next = head;
                   cur1 = cur1.next;
               }
            }else{
                if(cur2==null){
                    cur2 = head;
                    head2 = cur2;
                }else{
                    cur2.next = head;
                    cur2 = cur2.next;
                }
            }
            head = head.next;
            count++;
        }
        //跳出循环，要让最后两个末尾元素的下一个都指向null
        cur1.next = null;
        cur2.next = null;

        head2 = reverse(head2);
        return mergeLists(head1,head2);
    }

    public ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        ListNode pre = null;
        ListNode cur =head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre =cur;
            cur = next;
        }
        return pre;
    }

    public ListNode mergeLists(ListNode l1,ListNode l2){
        ListNode head = new ListNode();
        ListNode dummy = head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        while(l1!=null){
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }
        while(l2!=null){
            head.next = l2;
            l2=l2.next;
            head = head.next;
        }
        return dummy.next;
    }


    //对应leetcode 328题，将奇数位置的节点和偶数位置的节点分开
    //比如1->2->3->4->5 改为 1->3->5->2->4
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode odd = head;

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode even = fast;

        ListNode newHead = odd;
        ListNode newEvenHead = even;

        while(slow!=null && slow.next!=null && fast!=null && fast.next!=null){
            slow=slow.next.next;
            odd.next= slow;
            odd = odd.next;

            fast = fast.next.next;
            even.next= fast;
            even = even.next;
        }

        odd.next=newEvenHead;
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
        ListNode node6=new ListNode(6);
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

        ListNode result = new Odd_Even_Linked_List().oddEvenList(node1);
        while(result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}