package leetcode.DP;

/**
 * 交织的字符串
 *
 * @author zhihua on 2021/3/10
 */
public class Interleaving_String {
    /**
     * 第一种思路，回溯法
     * 用递归的方式不断尝试各种组合，s1[0..i], s2[0..j] 每次取其中一位拼凑一个res中间值。
     * 比如s1=abc，s2=bcd，s3=abcbdc,第一次递归到返回ans时，res=abcbcd，res!=s3,然后回溯再尝试另外一种组合
     * 当res==s3 && i==s1.length && j==s2.length 时 说明s1，s2都遍历完成，而且平凑的值res==s3，说明s3可以由s1，s2交织而成。
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        return backtrack(s1,0,s2,0,"",s3);
    }

    public boolean backtrack(String s1,int i,String s2,int j,String res,String s3){
        if(i==s1.length() && j==s2.length()&& res.equals(s3)){
            return true;
        }

        boolean ans = false;
        if(i<s1.length()){
            ans = ans | backtrack(s1,i+1,s2,j,res+s1.charAt(i),s3);
        }
        if(j<s2.length()){
            ans= ans| backtrack(s1,i,s2,j+1,res+s2.charAt(j),s3);
        }
        return ans;
    }

    /**
     * 第二种思路，二维dp
     * dp[i][j] 表示 s1的前[0..i]字符 和 s2的前[0..j] 个字符 通过某种排列方式 等于 s3 的前s3[0..k]个字符。这里k=i+j+2
     * 初始化dp[s1.length][s2.length],dp[0][0]=true.dp[0][0] 表示s1的空串，和s2的空串，如果s3也是空串那么必定是true，如果
     * s3不是空串，那么后面的逻辑也不会走，所以dp[s1.length][s2.length]=false,依然正确。
     * 接下来有两种情况要讨论：
     * 1，如果s1[0..i] s2[0..j] 和s3[0..k]不匹配，k=i+j+1,那么此时遍历的字符无论怎么组合也一定不会匹配s3的前i+j+2个字符。
     * 即dp[i][j] = false
     * 2，如果s1[0..i] s2[0..j] 和s3[0..k]匹配，k=i+j+1,那么如果此时遍历的字符无论是在s1上，还是在s2上，即如果s1[i]==s3.charat(i+j-1)
     * 或者s2[j]==s3.charat(i+j-1) ,那么dp[i][j]=true
     *
     */
    public boolean isInterleave_2DP(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                //初始化i=0时
                else if(i==0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }
                else if(j==0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                }
                else{
                    dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) ==s3.charAt(i+j-1))||(dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args){
        System.out.println(new Interleaving_String().isInterleave_2DP("abc","bcd","abcbdc"));
    }
}