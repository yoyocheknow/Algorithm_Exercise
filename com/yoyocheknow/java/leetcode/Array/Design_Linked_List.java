package leetcode.Array;

import java.io.LineNumberReader;

/**
 * 设计一个链表
 *
 * @author zhihua on 2021/1/9
 */
public class Design_Linked_List {

    public class Node {
        private int value;
        private Node next;
    }

    private Node head;

    public Design_Linked_List(){

    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node current = head;
        for(int i = 0 ; current != null && i < index ; i++) {
            current = current.next;
        }
        return current != null ? current.value : -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node();
        node.value = val;
        node.next = head;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node();
        node.value = val;

        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else {
            Node current = head;
            for(int i = 0 ; current != null && i < index - 1 ; i++) {
                current = current.next;
            }
            if (current != null) {
                Node node = new Node();
                node.value = val;
                node.next = current.next;
                current.next = node;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for(int i = 0 ; current != null && i < index - 1 ; i++) {
                current = current.next;
            }
            if (current != null && current.next != null) {
                current.next = current.next.next;
            }
        }
    }

    public static void main(String[] args){
        Design_Linked_List list = new Design_Linked_List();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        list.get(1);
        list.deleteAtIndex(1);
        list.get(1);
    }
}