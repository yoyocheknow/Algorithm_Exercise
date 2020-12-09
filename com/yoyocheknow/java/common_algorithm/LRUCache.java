package common_algorithm;

import java.util.*;

/**
 * lru算法实现
 *
 * @author zhihua on 2020/11/8
 */

public class LRUCache {

    private HashMap<Integer, Integer> map;

    private Deque<Integer> deque;

    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap();
        this.deque = new ArrayDeque();
        this.capacity=capacity;
    }

    public int get(int key) {
        if(this.map.containsKey(key)){
            //包含key则从队列中去除，然后新加进来
            this.deque.remove(key);
            this.deque.addLast(key);
            return this.map.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(!this.map.containsKey(key)){
            this.deque.addLast(key);
            this.map.put(key,value);
        }
        else{
            this.deque.remove(key);
            this.deque.addLast(key);
            this.map.put(key,value);
        }
        if(this.deque.size()>capacity){
            int evacuate = this.deque.pollFirst();
            this.map.remove(evacuate);
        }
    }

    public static void main(String[] args){
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(2,2);
        lRUCache.put(1, 1);
        System.out.println(lRUCache.toString());
        lRUCache.put(3, 3);
        System.out.println(lRUCache.toString());
        lRUCache.put(4, 4);
        System.out.println(lRUCache.toString());
        lRUCache.get(1);
        System.out.println(lRUCache.toString());
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map +
                ", deque=" + deque +
                ", capacity=" + capacity +
                '}';
    }
}