package leetcode.DP;

/**
 * 连续字符围城面积最长的矩形
 *
 * @author zhihua on 2021/1/11
 */
public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;

        if(row<=0){
            return 0;
        }
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        /**
         * dp[i][j] 存的是(i,j) 到达底部的最长连续'1'的长度
         * 如下所示
         * 4 0 3 0 0
         * 3 0 2 3 2
         * 2 1 1 2 1
         * 1 0 0 1 0
         *
         * 然后遍历dp数组，以(i,j)开始，遍历每一行的dp，
         * dp[i][j] 的值相当于宽，每一行连续'1'的的长度相当于长，长*宽 = 面积
         * 取最大即可
         */
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if (matrix[i][j] == '0') continue;
                if (i - 1 >= 0 && matrix[i - 1][j] != '0') dp[i][j] = dp[i - 1][j] - 1;
                else dp[i][j] = calculate(i, j, matrix);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(findMax(i, j, dp, matrix), max);
            }
        }
        return max;
    }

    int calculate(int row, int col, char[][] matrix) {
        int count = 1;
        for (int i = row + 1; i < matrix.length; i++) {
            if (matrix[i][col] == '0') break;
            count++;
        }
        return count;
    }

    int findMax(int row, int col, int[][] dp, char[][] matrix) {
        int max = 0;
        int recs = 0;
        int minSize = Integer.MAX_VALUE;
        for (int j = col; j < dp[0].length; j++) {
            if (matrix[row][j] == '0') break;
            minSize = Math.min(dp[row][j], minSize);
            max = Math.max(minSize * (recs + 1), max);
            recs++;
        }
        return max;
    }
    public static void main(String[] args){
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(new Maximal_Rectangle().maximalRectangle(matrix));
    }
}
