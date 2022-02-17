package common_algorithm;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    public static class Node{
        int key;
        int value;
        int frequency;
        Node pre;
        Node next;
        Node(int key,int value,int frequency){
            this.key=key;
            this.value=value;
            this.frequency=frequency;
        }
        @Override
        public String toString() {
            return "{" +
                    "key=" + key +
                    ", frequency=" + frequency +
                    '}';
        }
    }
    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    private Map<Integer,Node> map;

    public LFUCache(int capacity){
        this.capacity=capacity;
        this.size=0;
        this.head = new Node(0,0,0);
        this.tail = new Node(0,0,0);
        this.head.next=tail;
        this.tail.pre=head;
        this.map=new HashMap<>();
    }

    public int get(int key){
        Node node = map.get(key);
        if(node==null){
            return -1;
        }
        freqPlus(node);
        return node.value;
    }

    public void put(int key,int value){
        if(capacity<=0){
            return;
        }
        Node node=map.get(key);
        if(node!=null){
            node.value=value;
            freqPlus(node);
        }else{
            Node newNode = new Node(key,value,0);
            map.put(key,newNode);
            size++;
            if(size>capacity){
                eliminate();
            }
            //新数据插入末尾
            Node tailPre = tail.pre;
            tail.pre=newNode;
            newNode.pre=tailPre;
            tailPre.next=newNode;
            newNode.next=tail;
            freqPlus(newNode);
        }

    }
    //给当前节点的频率加1，并调整在链表中的顺序
    private void freqPlus(Node node){
        node.frequency++;
        Node pre = node.pre;
        int freq = node.frequency;
        while(pre!=null){
            //找到比当前节点频率大的节点，然后插入，并相应调整顺序
           if(pre.frequency>freq || pre==head){
               node.pre.next=node.next;
               node.next.pre=node.pre;

               Node next = pre.next;
               pre.next=node;
               node.next=next;

               node.pre=pre;
               next.pre=node;
               break;
           }
           pre=pre.pre;
        }
    }

    private void eliminate(){
        if(size<capacity){
            return;
        }

        //将最后一个节点删除
        Node last = tail.pre;
        last.pre.next=tail;
        tail.pre=last.pre;
        map.remove(last.key);
        size--;
        last=null;
    }

    public static void main(String[] args){

        LFUCache lfu = new LFUCache(2);
        lfu.put(3, 1);
        // cache=[1,_], cnt(1)=1
        lfu.print();
        lfu.put(2, 1);
        lfu.print();
        lfu.put(2, 2);// cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.print();
        lfu.put(4, 4);
        lfu.print();
        lfu.get(2);
        System.out.println(lfu);
//        lfu.get(1);      // return 1
//        System.out.println(lfu);
//        // cache=[1,2], cnt(2)=1, cnt(1)=2
//        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
//        System.out.println(lfu);
//        // cache=[3,1], cnt(3)=1, cnt(1)=2
//        lfu.get(2);      // return -1 (not found)
//        lfu.get(3);      // return 3
//        // cache=[3,1], cnt(3)=2, cnt(1)=2
//        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
//        // cache=[4,3], cnt(4)=1, cnt(3)=2
//        lfu.get(1);      // return -1 (not found)
//        lfu.get(3);      // return 3
//        // cache=[3,4], cnt(4)=1, cnt(3)=3
//        lfu.get(4);      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
    public void print(){
        System.out.print(head.value+" ");
        Node cur=head;
        while (cur.next!=tail){
            System.out.print(cur.next.key+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    @Override
    public String toString() {
        return "LFUCache{" +
                "map=" + map +
                ", capacity=" + capacity +
                '}';
    }
}
