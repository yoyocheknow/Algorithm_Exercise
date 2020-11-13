package leetcode.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 摇摆子序列
 *
 * @author zhihua on 2020/11/13
 */
public class WiggleSubsequence {


    public static  int wiggleMaxLength(int[] nums) {
        //摇摆子序列
        //利用贪心思路解这道题。当上升时，如果当前值大于前一个值，说明还是处于上升序列，则继续遍历，直到找到小于上一个值，说明是拐点，此时拐点可以加入子序列中
        //当上升时，直到当前值小于上一个值，说明出现了拐点，此时要加入结果子序列
        //当下降时，直到当前值大于上一个值，说明出现了拐点，此时要加入结果子序列
         final int BEGIN =0;
         final int UP =1;
         final int DOWN =2;
        if(nums.length<2){
            return nums.length;
        }
        int count=1;
        int state=BEGIN;
        for(int i=1;i<nums.length;i++){
            switch (state){
                case BEGIN:
                    if(nums[i-1]<nums[i]){
                        state=UP;
                        count++;
                    }
                    else if(nums[i-1]>nums[i]){
                        state=DOWN;
                        count++;
                    }
                    break;
                case UP:
                    if(nums[i-1]>nums[i]){
                        state=DOWN;
                        count++;
                    }
                    break;
                case DOWN:
                    if(nums[i-1]<nums[i]){
                        state=UP;
                        count++;
                    }
                    break;
            }
        }

        return count;
    }

    public static void main(String args[]){
        System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}