package leetcode.DP;

/**
 * 独一无二的路径
 * 动态规划思路：类似爬楼梯，到达目标处，有两种方式到达，从上方或者左方。
 * dp[i][j] 表示到达i，j时独一无二的路径的数量
 * dp[0][0]=1
 * 递推方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * @author zhihua on 2021/3/2
 */
public class Unique_Paths {
    public int uniquePaths(int m, int n) {
        if(m>1 && n<1){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //边界处理
                if(i==0){
                    if(j==0|| j==1)
                        dp[i][j] =1;
                    else dp[i][j] = dp[i][j-1];
                }
                else if(j==0){
                    if(i==0|| i==1)
                        dp[i][j] =1;
                    else dp[i][j] = dp[i-1][j];
                }
                else dp[i][j]  =  dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args){
        System.out.println(new Unique_Paths().uniquePaths(2,1));
    }
}