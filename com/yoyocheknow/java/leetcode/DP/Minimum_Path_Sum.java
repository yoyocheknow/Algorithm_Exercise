package leetcode.DP;

/**
 * 最小路径和
 *
 * @author zhihua on 2020/12/3
 */
public class Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        if(grid.length<1){
            return 0;
        }
        int[][]dp =new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i-1>=0 && j-1>=0){
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
                else if(i-1>=0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }
                else if(j-1>=0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }else{
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(new Minimum_Path_Sum().minPathSum(grid));
    }
}