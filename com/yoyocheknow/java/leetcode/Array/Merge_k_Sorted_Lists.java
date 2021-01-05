package leetcode.Array;

import dataStructure.ListNode;

/**
 * 合并K个有序链表
 *
 * @author zhihua on 2020/12/23
 */
public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1){
            return null;
        }
        int i = 1;
        ListNode l1 = lists[0];
        while(i<lists.length){
            //两两合并
            ListNode l2 =lists[i];
            l1 = mergeList(l1,l2);
            i++;
        }
        return l1;
    }

    public ListNode mergeList(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(l1!=null&& l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            }else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        while(l1!=null){
            tail.next=l1;
            l1= l1.next;
            tail=tail.next;
        }
        while(l2!=null){
            tail.next=l2;
            l2 = l2.next;
            tail=tail.next;
        }
        return dummy.next;
    }

    public static void main(String[]args){
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(4);
        ListNode node3=new ListNode(5);
        node1.next=node2;
        node2.next=node3;


        ListNode node4=new ListNode(1);
        ListNode node5=new ListNode(3);
        ListNode node6=new ListNode(4);
        node4.next=node5;
        node5.next=node6;

        ListNode node7=new ListNode(-1);
        ListNode node8=new ListNode(6);

        node7.next=node8;

        ListNode[] ls = new ListNode[]{node1,node4,node7};
        ListNode result = new Merge_k_Sorted_Lists().mergeKLists(ls);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}