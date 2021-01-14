package leetcode.Array;

import dataStructure.ListNode;

/**
 * 从有序的链表中删除重复节点II
 *
 * @author zhihua on 2021/1/13
 */
public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        /**
         *     0 ----> 2 ----> 3 ----> 3 ----> 4
         *     |       |       |       |       |
         *  sentinel  pre    delete  delete    |
         *             |_______________________|
         *
         */
        // sentinel
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node
        // before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // skip all duplicates
                pred.next = head.next;
                // otherwise, move predecessor
            } else {
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }
        return sentinel.next;

    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);


        l1.next=l2;
        l2.next=l3;
        l3.next=l4;

        ListNode result = new Remove_Duplicates_from_Sorted_List_II().deleteDuplicates(l1);
        while (result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}