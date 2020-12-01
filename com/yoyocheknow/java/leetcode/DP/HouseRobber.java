package leetcode.DP;

/**
 * 打家劫舍
 *
 * @author zhihua on 2020/12/1
 */
public class HouseRobber {
    /**
     * dp
     * 定义dp[i]为前i家 抢劫到最大的金币数
     * 如果打结第i家那么一定不能打劫第i-1家。
     * 那么状态转移方程：
     * dp[i] = max(dp[i-2]+nums[i],dp[i-1])
     * 初始状态dp[0] = nums[0],dp[1] = max(nums[0],nums[1])
     */
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length<2){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args){
        System.out.println(new HouseRobber().rob(new int[]{5,2,6,3,1,7}));
    }
}