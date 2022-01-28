package leetcode.Array;

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

    public static  int[] twoSum1(int[] nums, int target) {
        int i=0;
        int length = nums.length;
        int[] re = new int[2];

        while(i<length){
            int x = target-nums[i];
            re[0]=i;
            int j = i+1;
            while(j<length){
                if(x==nums[j]){
                    re[1]=j;
                    break;
                }
                j++;
            }
            if(re[1]!=0){
                break;
            }
            i++;

        }
        return re;
    }
    public static void main(String[] args){
        int[] nums = new int[]{3,2,4};
        int [] result = twoSum1(nums,6);
        Arrays.stream(result).forEach(System.out::println);
    }
}