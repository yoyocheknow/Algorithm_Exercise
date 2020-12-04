package leetcode.DP;

/**
 * 买卖股票的最佳时机II
 *
 * @author zhihua on 2020/12/3
 */
public class Best_Time_to_Buy_and_Sell_StockII {
    /**
     * 只要把利润差累加起来即可
     * 利润差就是 prices[i] - prices[i - 1]之和
     */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args){
        System.out.println(new Best_Time_to_Buy_and_Sell_StockII().maxProfit(new int[]{1, 7, 2, 3, 6, 7, 6, 7}));
    }
}