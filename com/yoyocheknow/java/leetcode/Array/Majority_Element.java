package leetcode.Array;

import java.util.HashMap;

/**
 * 大多数元素
 *
 * @author zhihua on 2021/1/24
 */
public class Majority_Element {
    public int majorityElement(int[] nums) {
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int count =map.get(nums[i]);
                count++;
                map.put(nums[i],count);
            }else{
                map.put(nums[i],1);
            }

            if(map.get(nums[i])>size/2){
                return nums[i];
            }
        }
        return -1;
    }
    public static void main(String []args){
        System.out.println(new Majority_Element().majorityElement(new int[]{2}));
    }
}