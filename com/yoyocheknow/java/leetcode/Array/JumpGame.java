package com.yoyocheknow.java.leetcode.Array;

/**
 * 数组跳跃问题
 *
 * @author zhihua on 2020/11/11
 */
public class JumpGame {
    //整体思路是：从数组第一位开始，记录每次能够到达最远的地方。
    //当遍历完整个数组时判断这个最远的地方是否大于数组长度，大于等于则可以跳成功。
    //while 的第二个限制条件是防止 jump指针无脑向前移动。因为如果nums一个值为0的话，是不能向前移动的。
    //jump的移动范围只能在max_index之内。
    public static boolean canJump(int[] nums) {
        if(nums.length<2){
            return true;
        }
        int jump =0;
        int max_index = nums[0];
        while(jump<nums.length && jump<=max_index){
            max_index = Math.max(max_index,nums[jump]+jump);
            jump++;
        }
        if(max_index>=nums.length-1){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args){
        int []nums = new int[]{2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}