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
            return "Node{" +
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
            eliminate();
            Node newNode = new Node(key,value,0);
            map.put(key,newNode);
            size++;

            //新数据插入末尾
            Node tailPre = tail.pre;
            tail.pre=newNode;
            newNode.pre=tailPre;
            newNode.next=newNode;
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
               node.pre.next=pre.next;
               node.next.pre=node.pre;
               Node next = pre.next;
               pre.next=node;
               next.pre=node;
               node.next=next;
               node.pre=pre;
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
        LFUCache lfUCache = new LFUCache(3);
        lfUCache.put(2,2);
        lfUCache.put(1, 1);
        System.out.println(lfUCache.toString());
        lfUCache.put(3, 3);
        System.out.println(lfUCache.toString());
        lfUCache.put(4, 4);
        System.out.println(lfUCache.toString());
        lfUCache.get(1);
        System.out.println(lfUCache.toString());
    }
    @Override
    public String toString() {
        return "LFUCache{" +
                "map=" + map +
                ", capacity=" + capacity +
                '}';
    }
}
