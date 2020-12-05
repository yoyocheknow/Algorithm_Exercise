package leetcode.DP;

import java.util.Arrays;

/**
 * 买卖股票最佳时机IV
 *
 * @author zhihua on 2020/12/5
 */
public class Best_Time_to_Buy_and_Sell_StockIV {
    /**
     * 和前几道题目不同，这次的交易次数由k指定
     * 用一个三维数组dp[i][k][s]表示 第i天，持有/没有持有股票 还剩k次交易时的最大收益
     * s只有两种情况 sell or rest 卖掉或持有，用0代表卖掉 1代表持有
     * 状态转移方程：
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * 表示 第i天没有持有股票的收益 = max（前一天没有持有股票的收益，前一天持有股票然后今天卖掉的收益）
     * dp[i][k][1] = max(dp[i-1][k-1][0]-prices[i], dp[i-1][k][1])
     * 表示 第i天持有股票的收益 = max(前一天没有股票然后花钱买了一股剩下的钱，前一天就持有一股)，此时买股票，k-1 表示减少一次交易数量
     * 初始值：
     * dp[i][0][0] = 0 k从1开始，此时还没有开始交易，收益为0
     * dp[i][0][1]= -infinity 不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
     */
    public int maxProfit(int k, int[] prices) {
        //nums[i]存放交易前的股票价格
        int[] nums = new int[k];
        //profits[i]存放第i次交易的收益
        int[] profits = new int[k];
        Arrays.fill(nums, Integer.MAX_VALUE);
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i ++) {
            int profit = 0;
            // extend to K transaction  from 2 transaction.
            for(int j = 0; j < k; j ++) {
                //交易前的股票价格=min(nums[j],当前股票的价格-上一次的收益)
                nums[j] = Math.min(nums[j], prices[i] - profit);

                profits[j] = Math.max(profits[j], prices[i] - nums[j]);
                profit = profits[j];
            }
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    public static void main(String[] args){
        System.out.println(new Best_Time_to_Buy_and_Sell_StockIV().maxProfit(2,new int[]{3,2,6,5,0,3}));
    }
}