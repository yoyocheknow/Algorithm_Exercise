package leetcode.DP;

import java.util.Arrays;

/**
 * 打家劫舍II
 * 这个问题和上一个基本类似，主要区别在于它是一个环，首尾两家是挨着的。
 * 那么就是说，中间计算时，要么取首，要么取尾。保证不让两者同时取到即可。
 * 所以可以使用动态思路，分别从头部遍历到i-2,和从尾部遍历到1
 * 这样就不会同时取到首和尾，那么比较两次过程中的最大值即可。
 * @author zhihua on 2021/3/8
 */
public class House_Robber_II {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len<1){
            return 0;
        }
        if(len<2){
            return nums[0];
        }
        int[] dp = new int[len];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<len-1;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        int max = dp[nums.length-2];
        Arrays.fill(dp,0);
        dp[len-1]=nums[len-1];
        dp[len-2]=Math.max(nums[len-1],nums[len-2]);
        for(int i=len-3;i>0;i--){
            dp[i] = Math.max(dp[i+2]+nums[i],dp[i+1]);
        }
        max = Math.max(dp[1],max);
        return max;
    }
    public static void main(String[] args){
        System.out.println(new House_Robber_II().rob(new int[]{1,3,1,3,100}));
    }
}