package leetcode.DP;

/**
 * 最大连续子序列之和
 *
 * @author zhihua on 2020/12/1
 */
public class MaximumSubarray {
    /**
     * 定义dp[i]表示包含第i个的前i个序列最大和.（记住是包含第i个元素）
     * 初始状态：dp[0]=nums[0]
     * 状态转移方程：
     * dp[i] = max(dp[i-1]+nums[i],nums[i])
     *
     */
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp =new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i =1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            //max用来收集dp数组中的最大值
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void  main(String []args){
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-1,-2}));
    }
}