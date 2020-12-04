package leetcode.DP;

/**
 * 买卖股票最佳时机III
 *
 * @author zhihua on 2020/12/4
 */
public class Best_Time_to_Buy_and_Sell_StockIII {
    /**
     * 买卖股票最多可以两次
     * 由于两次买卖是不会交叉的，可以从左边遍历可以产生的最佳利润
     * 同时从右边也遍历利润。
     * 两个利润list 的组合之和中找到一组最大的即为题意
     */
    public int maxProfit(int[] prices) {
        //left[i]存放的是从0开始的一次买卖最佳利润
        int[] left = new int[prices.length];
        //right[i]存放的是从i-1开始的一次买卖最佳利润
        int[] right = new int[prices.length];

        int leftMin=prices[0];
        int rightMax = prices[prices.length-1];

        for(int i=1;i<prices.length;i++){
            //找到最低的买入价格
            leftMin=Math.min(leftMin,prices[i]);
            //当前价格比上一个低价格高，就卖掉
            left[i] = Math.max(prices[i]-leftMin,left[i-1]);
        }

        for(int j=prices.length-2;j>=0;j--){
            rightMax=Math.max(rightMax,prices[j]);
            right[j]=Math.max(rightMax-prices[j],right[j+1]);
        }

        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            maxProfit = Math.max(maxProfit,left[i]+right[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args){
        System.out.println(new Best_Time_to_Buy_and_Sell_StockIII().maxProfit(new int[]{1, 7, 2, 3, 6, 7, 6, 7}));
    }
}