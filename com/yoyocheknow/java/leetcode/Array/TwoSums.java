package com.yoyocheknow.java.leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author zhihua on 2020/11/2
 */
public class TwoSums {
    public static  int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tempMap = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            if(tempMap.get(nums[i])==null){
                int key = target-nums[i];
                tempMap.put(key,i);
            }else{
                result[0] = tempMap.get(nums[i]);
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,7,11,15};
        int [] result = twoSum(nums,17);
        Arrays.stream(result).forEach(System.out::println);
    }
}