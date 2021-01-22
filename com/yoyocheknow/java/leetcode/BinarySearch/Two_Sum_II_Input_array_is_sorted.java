package leetcode.BinarySearch;

import java.util.HashMap;

/**
 * 两数之和-有序列表
 *
 * @author zhihua on 2021/1/22
 */
public class Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int low=0;
        int high = numbers.length-1;
        int[] result = new int[2];
        while(low<high){
            int s = numbers[low] + numbers[high];
            if(s == target)
                return new int[]{low + 1, high + 1};
            else if(s < target)
                low++;
            else
                high--;
        }
        return result;
    }

    public static void main(String[] args){
        int [] result = (new Two_Sum_II_Input_array_is_sorted().twoSum(new int[]{-1,0},-1));
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}