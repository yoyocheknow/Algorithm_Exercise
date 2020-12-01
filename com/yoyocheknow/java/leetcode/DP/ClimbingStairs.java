package leetcode.DP;

/**
 * 爬楼梯
 *
 * @author zhihua on 2020/12/1
 */
public class ClimbingStairs {
    //第n阶楼梯可以从第n-1阶，第n-2阶楼梯爬上去。
    //所以dp[n]=dp[n-1]+dp[n-2]
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int [] dp =new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(new ClimbingStairs().climbStairs(4));
    }
}