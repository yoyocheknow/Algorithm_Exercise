package leetcode.DP;

/**
 * 两个字符串的最小差异
 *
 * @author zhihua on 2021/1/10
 */
public class Edit_Distance {
    /**
     *      h o r s e
     *    0 1 2 3 4 5
     * r  1 1 2 2 3 4
     * o  2 2 1 2 3 4
     * s  3 3 2 2 2 3
     *
     * dp思想
     * 求两个字符串的的最小差异
     * dp[i][j] 表示从w1[0..i] 与w2[0..j]之间的最小差异
     * 初始化：dp[0][0] =0;表示两个空字符串之间没有差异。
     * dp[0][0...j] 初始化为0...j 表示w1为空字符串，分别到w2[j]j位置的最小差异，那么就是0...j
     * dp[0...i][0] 初始化为0...i 表示w2为空字符串，分别到w1[i]位置的最小差异为0...i
     * 状态转移方程：
     * dp[i][j] = if w1[i-1]==w[j-1] --> dp[i-1][j-1] (如果w1的第i个字符和w2的第j个字符相同，那么dp[i][j] = dp[i-1][j-1])
     *          = else --> 1,把i-1 和j-1的字符都去掉 = dp[i-1][j-1]
     *                 --> 2,把i-1的字符替换 即 = dp[i-1][j]
     *                 --> 3,把j-1的字符替换 即 = dp[i][j-1]
     *                 然后取三者之前的最小值+1即可。
     *
    */
    public int minDistance(String word1, String word2) {
        int[][] dp= new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        System.out.println(new Edit_Distance().minDistance("ros","horse"));
    }
}