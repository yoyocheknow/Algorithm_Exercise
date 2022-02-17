package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new ArrayDeque();
        int[] result = new int[nums.length-k+1];

        int end=0;
        int start=0;
        int index=0;
        //使用一个队列，队列头部存放窗口范围的最大值
        while(end<nums.length){
            //遇见比队列尾部大的值，则将队列清空，放入最大值
            while(!deque.isEmpty() && nums[end]>deque.peekLast()){
                deque.pollLast();
            }
            deque.addLast(nums[end]);
            if(end-start+1==k){
                //队列头部存的是最大值，所以更新到结果数组中
                if(!deque.isEmpty()){
                    result[index++]=deque.peekFirst();
                }
                //如果窗口最左边的值==队列最大值，那么此时就应该滑动窗口了，slide the window，队列弹出头部
                if(nums[start]==deque.peekFirst())
                    deque.pollFirst();
                start++;
                end++;
            }else{
                end++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] arr = slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},2);
        for(int i:arr){
            System.out.print(i +" ");
        }

    }
}
