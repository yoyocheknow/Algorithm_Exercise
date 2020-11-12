package com.yoyocheknow.java.leetcode.Array;

/**
 * 容器接雨水问题
 *
 * @author zhihua on 2020/11/11
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left=0;
        int right = height.length-1;
        int maxRain=0;
        while(left<right){
            int rain =(right-left)*(Math.min(height[left],height[right]));
            maxRain = Math.max(maxRain,rain);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxRain;
    }
    public static void main(String[] agrs){
        int [] height = new int[]{4,3,2,1,4};
        System.out.println(maxArea(height));
    }
}