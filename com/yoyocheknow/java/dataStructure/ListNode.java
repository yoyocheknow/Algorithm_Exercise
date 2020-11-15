package dataStructure;

import common_algorithm.ReverseList;

/**
 * 链表
 *
 * @author zhihua on 2020/11/15
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value){
        this.value=value;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ListNode getNext() {
        return next;
    }
}