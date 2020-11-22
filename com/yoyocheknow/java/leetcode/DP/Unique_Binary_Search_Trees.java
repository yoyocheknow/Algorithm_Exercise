package leetcode.DP;

/**
 * 构造独特二叉搜索树的数量
 *
 * @author zhihua on 2020/11/22
 */
public class Unique_Binary_Search_Trees {
    /**
     * 整体思路：
     * 对于序列[1...i...n],如果i为root的话，[1...i-1]序列将作为左子树，[i+1...n]将作为右子树。那么此时二叉搜索树的数目为：
     * numTrees(i-1）* numTrees(n-i)
     * 将所有节点作为root的二叉搜索树之和即为结果。
     *
     */
    public int numTrees(int n) {
        // create the dp array of size n+1
        int [] dp = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            //计算1...n每一个节点作为root时的个数，然后相加
            //dp[i-j]表示 i为root时，右子树的个数
            //dp[j-1]表示 i为root时，左子树的个数
            for (int j=1; j<=i; j++) {
                dp[i] = dp[i] + (dp[i-j] * dp[j-1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        Unique_Binary_Search_Trees u =new Unique_Binary_Search_Trees();
        System.out.println(u.numTrees(5));
    }
}