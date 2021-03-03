package leetcode.DP;

/**
 * 独特的路径II
 * 动态规划思路：类似爬楼梯，到达目标处，有两种方式到达，从上方或者左方。
 * dp[i][j] 表示到达i，j时独一无二的路径的数量
 * 初始化：dp[0][0]=1
 * dp[0][j] = 1,dp[i][0] = 1
 * 递推方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * @author zhihua on 2021/3/3
 */
public class Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length<1){
            return 0;
        }
        int[][]dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        //初始化dp
        for(int j=0;j<obstacleGrid[0].length;j++){

            dp[0][j]=1;
            //如果在此处有障碍，那么后面是走不到的，所以break
            if(obstacleGrid[0][j]==1){
                dp[0][j]=0;
                break;
            }
        }
        for(int i=0;i<obstacleGrid.length;i++){
            dp[i][0]=1;
            //如果在此处有障碍，那么后面是走不到的，所以break
            if(obstacleGrid[i][0]==1){
                dp[i][0]=0;
                break;
            }
        }

        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[i].length;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }

            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args){
        int[][] obstacleGrid = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(new Unique_Paths_II().uniquePathsWithObstacles(obstacleGrid));
    }
}