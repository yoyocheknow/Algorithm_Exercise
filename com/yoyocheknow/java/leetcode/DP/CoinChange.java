package leetcode.DP;

import java.util.Arrays;
import java.util.Collections;

/**
 * 找零钱
 *
 * @author zhihua on 2020/12/1
 */
public class CoinChange {
    /**
     * 定义dp[i] 表示金额i需要最少的数量
     * dp[0]=0
     * 状态转移方程：
     * dp[i] = min(dp[i-coins[0]],dp[i-coins[1]]...)+1
     * 比如 coins = [1,2,5], amount = 11
     * dp[11] = min(dp[10], dp[9], dp[6])+1
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String args[]){
        System.out.print(new CoinChange().coinChange(new int[]{1,2,5},11));
    }
}