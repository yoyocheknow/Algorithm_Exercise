package leetcode.DP;

/**
 * 正则表达式匹配
 * '.' Matches any single character.​​​​ '.' 可以匹配任一字符
 * '*' Matches zero or more of the preceding element. '*' 可以匹配前面字符的0次或者多次
 * @author zhihua on 2021/2/28
 */
public class Regular_Expression_Matching {
    //回溯法
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }
        //如果s,p都不为空，并且当前字符相同或者 p当前为'.' ,那么此时匹配
        boolean firstMatch = false;
        if(!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0)=='.')){
            firstMatch = true;
        }
        //如果P的长度超过2，并且第二个字符是*，这样的话，这个*有两种情况，1-匹配前面的字符0次，2-匹配前面的字符N次
        if(p.length()>=2 && p.charAt(1) == '*'){
            //matchZeroPreceding 代表P当前的'*' 重复前面的元素0次，那么也就是说当前的*和前面的元素一起消失了。进入下一次递归的是整个S和P[2:]
            boolean matchZeroPreceding = isMatch(s,p.substring(2));
            //matchMorePreceding 代表 p当前的*，重复前面的元素多次.
            //如果第一个字符匹配了，那么剩下的递归中，S只需取剩下的元素[1:],而P则需取当前整个字符。
            //因为P中*此时重复前面元素N次，就是为了与S匹配，所以进入下次递归时仍要带上前面的那个字符，这样才能体现重复多次的情况
            boolean matchMorePreceding = firstMatch && isMatch(s.substring(1),p);
            return matchZeroPreceding || matchMorePreceding;
        }
        //此种情况是p的第二个元素不是'*'，那么比较完第一个元素，就比较后面其他元素。
        else {
            return firstMatch && isMatch(s.substring(1),p.substring(1));
        }
    }


    /**
     *  动态规划
     *  dp[i][j] 表示s[0..i] 与p[0..j] 是否匹配
     *  比如 s='aaac',p='a*c'
     *  0 代表false，1代表true
     *  dp p| 0 1 2 3
     *  ----------------------------
     *  s  0| 1 0 1 0
     *     1| 0 1 1 0
     *     2| 0 0 1 0
     *     3| 0 0 1 0
     *     4| 0 0 0 1
     */

    public boolean isMatch1(String s, String p) {
        if(s.length()==0 && p.length()==0){
            return true;
        }
        if(p.length()==0){
            return false;
        }
        int m = s.length();
        int n= p.length();
        boolean[][]dp = new boolean[m+1][n+1];

        //初始化动态方程
        dp[0][0]=true;
        //代表p为空时，dp数组的初始值。p的前0个字符都与s不匹配。
        for(int i=1;i<=m;i++){
            dp[i][0]=false;
        }
        //代表s为空时，dp数组的初始值
        for(int j=1;j<=n;j++){
            char c = p.charAt(j-1);
            if(Character.isLetter(c)|| c=='.'){
                dp[0][j]=false;
            }
            if(c=='*' && dp[0][j-2]){
                dp[0][j]=true;
            }
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                char a = s.charAt(i-1);
                char b = p.charAt(j-1);
                //如果s[0..i-1] 与p[0..j-1]匹配，并且 s[i]==p[j] or p[j]=='.' 那么s[0..i] 与p[0..j]匹配
                if(dp[i-1][j-1] && (a==b ||b=='.')){
                    dp[i][j]=true;
                    continue;
                }
                //b=='*'的话，有两种可能：
                //1，将前面的字符匹配零次
                //2，将前面的字符匹配多次
                if(b=='*'){
                    //将前面的字符匹配零次，那么当前字符*，和前面的字符一起消失。只需判断dp[i][j-2]即可
                    if(dp[i][j-2]){
                        dp[i][j]=true;
                        continue;
                    }
                    //将前面的字符匹配多次。比如现在的s=aaac,p=a*c
                    //*应该可以将前面的a匹配两次。既然* 要匹配前面的字符 n次，那么至少说明s[0..i-1]要匹配
                    //并且，s当前的字符和*的前一个字符要相同，才能保证s[0..i] p[0..j]匹配。
                    if(dp[i-1][j]&& (a==p.charAt(j-2) || p.charAt(j-2) =='.')){
                        dp[i][j]=true;
                        continue;
                    }
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];

    }
    public static void main(String[] args){
        System.out.print(new Regular_Expression_Matching().isMatch1("aaac","a*c"));
    }
}