package leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形
 *
 * @author zhihua on 2020/12/2
 */
public class Triangle {
    /**
     * 重新声明一个二维的dp数组
     * dp的数字位置和trangle二维数组位置相同，但是dp数组的数字保存的是
     * 到达这一点的和。
     * dp[i][j] = min(dp[i-1][j-1],dp[i-1][j]) + trangle[i][j]
     * 最终符合题意的结果就是最后一行的最小值
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()<1){
            return 0;
        }
        int row = triangle.size();
        int col = triangle.get(triangle.size()-1).size();
        int[][] dp =new int[row][col];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(j-1>=0&& j<triangle.get(i-1).size()){
                    dp[i][j] =Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
                }else if(j-1<0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }else if(j>=triangle.get(i-1).size()){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }

            }
        }
        int min = dp[row-1][0];
        for(int i =1;i<col;i++){
            if(dp[row-1][i]<min){
                min = dp[row-1][i];
            }
        }

        return min;
    }

    public static void main(String[] args){
        List<Integer> r1 = Arrays.asList(2);
        List<Integer> r2 = Arrays.asList(3,4);
        List<Integer> r3 = Arrays.asList(6,5,7);
        List<Integer> r4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(r1);
        triangle.add(r2);
        triangle.add(r3);
        triangle.add(r4);
        System.out.println(new Triangle().minimumTotal(triangle));
    }
}