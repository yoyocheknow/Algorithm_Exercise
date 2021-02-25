package leetcode.Array;

import dataStructure.ListNode;

/**
 * 回文链表
 * 思路：使用两个指针slow，fast
 * fast每次走两步，直到队尾
 * slow每次走一步，这样保证slow最后落在链表中间。
 * 在这个期间，翻转前半部分的链表
 * 这样，前半部分的head变成了pre节点
 * 后半部分的head变成了 slow
 * 然后挨个比较两部分的节点即可。
 * @author zhihua on 2021/2/25
 */
public class Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        //此时pre是前半部分的头节点。slow是后半部分的头节点
        //判断节点的数量是奇数还是偶数
        //如果是奇数
        if(fast != null)    slow = slow.next;
        while (slow!=null){
            if(slow.val!=pre.val){
                return false;
            }
            slow= slow.next;
            pre = pre.next;
        }
        return true;


    }
    public static void main(String []args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;

        System.out.println(new Palindrome_Linked_List().isPalindrome(l1));
    }

}