package leetcode.Array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 是否包含重复项
 *
 * @author zhihua on 2021/2/20
 */
public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length<1){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(new Contains_Duplicate().containsDuplicate(new int[]{1,2,3,1}));
    }
}