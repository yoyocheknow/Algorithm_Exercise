package leetcode.Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Jump Game II
 *
 * @author zhihua on 2020/11/12
 */
public class JumpGameII {
    public static  int jump(int[] nums) {
        //贪心算法实现
        //此题要求最小跳跃次数，所以要把握好跳跃的时机，那么什么时候跳跃好呢？
        //中间维护了一个目前可以跳跃到最远处的index current_max_index，
        //当当前index >current_max_index时，说明就应该在current_max_index之前跳了。
        //那么是current_max_index之前什么时候跳最好呢？所以此时还要维护一个pre_max_index，
        //表示current_max_index之前可以跳跃最大的index
        //每当i>current_max_index时，更新current_max_index为pre_max_index
        //表示在pre_max_index该跳了，然后jump_min+1
        //每次向后遍历时都要更新pre_max_index的值，维护一个最大值
        if(nums.length<2){
            return 0;
        }
       int current_max_index = nums[0];
       int pre_max_index = nums[0];
       int jump_min=1;
       for(int i=0;i<nums.length;i++){
           if(i>current_max_index){
               current_max_index=pre_max_index;
               jump_min++;
           }
           pre_max_index =Math.max(pre_max_index,nums[i]+i);
       }
       return jump_min;
    }

    public static void main(String[] args){
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}