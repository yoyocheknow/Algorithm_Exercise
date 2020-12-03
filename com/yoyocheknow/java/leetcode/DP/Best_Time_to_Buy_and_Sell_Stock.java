package leetcode.DP;

/**
 * 买卖股票的最佳时机
 *
 * @author zhihua on 2020/12/3
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if(prices.length<1){
            return 0;
        }
        int[] dp =new int[prices.length];
        int minPre=prices[0];
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            dp[i] = prices[i] - minPre;
            minPre = Math.min(minPre,prices[i]);
            maxProfit = Math.max(maxProfit,dp[i]);
        }
        return maxProfit;
    }

    public static void main(String[]args){
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock().maxProfit(new int[]{7,6,4,3,1}));
    }
}