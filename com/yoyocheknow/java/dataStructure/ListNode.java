package dataStructure;

import common_algorithm.ReverseList;

/**
 * 链表
 *
 * @author zhihua on 2020/11/15
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val=val;
    }

    public ListNode() {

    }
    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }
}