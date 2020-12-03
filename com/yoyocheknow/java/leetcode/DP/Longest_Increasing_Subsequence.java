package leetcode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长上升子序列
 *
 * @author zhihua on 2020/12/2
 */
public class Longest_Increasing_Subsequence {
    /**
     * 定义dp[i]为以第i个元素结尾的上升序列长度
     * 初始值dp[0]=1
     * 如序列[1,3,2,3,1,4]
     * dp[0]=1,dp[1]=2,dp[2]=2,dp[3]=3,dp[4]=1
     * dp[5] = if nums[i]>nums[0...i-1], dp[i] = max(dp[0...i-1])+1
     */
    public int lengthOfLIS(int[] nums) {
        if(nums==null|| nums.length<1){
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0]=1;
        int max=1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            max = Math.max(dp[i],max);

        }
        return max;
    }

    public static void main(String[] args){
        System.out.print(new Longest_Increasing_Subsequence().lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}