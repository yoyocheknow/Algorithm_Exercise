package leetcode.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 不同的子序列
 *
 * @author zhihua on 2021/3/12
 */
public class Distinct_Subsequences {
    /**
     * 解法一，暴力回溯法
     * 主要思想还是拿着字符串s的每一个元素去和字符串t匹配
     * temp用于存储中间生成的临时字符串，一旦和t匹配那么，就是遍历到一个结果然后存储到result中。
     * i 用于记录s的指针，j用于记录t的指针
     * for循环主要用于每次回溯时从i开始，依次探测下一个元素
     * if中的判断条件主要用来减少回溯的次数
     */
    public int numDistinct(String s, String t) {
        List<String> result = new ArrayList<>();
        backtrack(s,0,t,0,"",result);
        return result.size();
    }

    public void backtrack(String s,int i,String t,int j,String temp,List<String> result){
        if(temp.equals(t)){
            result.add(temp);
            return;
        }
        for(int k = i;k<s.length();k++){
            if(s.charAt(k)==t.charAt(j)&& temp.length()<=t.length()){
                backtrack(s,k+1,t,j+1,temp+s.charAt(k),result);
            }
        }

    }

    /**
     * DP思路
     * 上面的 暴力回溯有很多情况其实是可以缓存的，这也是DP思想要做的事情，通过把上一步的结果进行记录，方便下次使用
     * 声明一个二维数组dp[t.length+1][s.length+1],dp[i][j] 表示s[0..j]有多少种方式可以和 t[0..i]匹配
     * 那么我们想要的结果就是当j=t.length 时，dp[s.length][t.length]=n,即代表s从0到s.length ,t从0到t.length 有n种方式匹配。
     * 初始化dp[0][j]表示,如果t为空串的话，s[0..i]均有1种情况（比如取s的空串） 与此空串匹配
     * 转移方程：
     * dp[i][j] = if(s.charAt(j-1) == t.charAt(i))： dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
     * 如果s当前的字符和t当前的字符相同，
     * 那么此时的dp[i][j] 依赖于s的截止到上一个字符和t的截止到上一个字符是否匹配。
     * 另外还依赖s的上一个字符是否和t截止到当前的字符匹配。因为，比如t字符串的rab这个子序列，s中的第1，2，3 可以与之匹配，1，2，4也可以与之匹配
     * 如果此时i=3,j=4,那么dp[3][4] = dp[3][3]+dp[3][4].
     * 如果s当前的字符和t当前的字符不同： dp[i][j] = dp[i][j-1]; 那么截止到当前t的前i个子序列，要依赖于s的前j-1个子序列看是否与之匹配。
     * 最终的结果是我们要找到dp[s.length][t.length] 的值，也就是说截止到第s.length的子序列，和截止到t.length的子序列，一共有几种情况
     * 与之匹配。
     *     r a b b b i t
     *   1 1 1 1 1 1 1 1
     * r 0 1 1 1 1 1 1 1
     * a 0 0 1 1 1 1 1 1
     * b 0 0 0 1 2 3 3 3
     * b 0 0 0 0 1 3 3 3
     * i 0 0 0 0 0 0 3 3
     * t 0 0 0 0 0 0 0 3
     */
    public int numDistinct_DP(String s, String t) {
        int [][] dp = new int[t.length()+1][s.length()+1];

        if(s.length()<1 && t.length()<1){
            return 1;
        }
        for(int j=0;j<=s.length();j++){
            dp[0][j]=1;
        }

        for(int i=1;i<=t.length();i++){
            for(int j=1;j<=s.length();j++){
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }

        return dp[t.length()][s.length()];
    }

    public int numDistinct_DP1(String s, String t){
        if(s.length()==0 || t.length()==0){
            return 0;
        }
        int cumsum =1;
        HashMap<Integer, Integer> dict = new HashMap();
        for(int i=0;i<t.length();i++){
            HashMap<Integer, Integer> new_dict = new HashMap();
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == t.charAt(i)){
                    new_dict.put(j,cumsum);
                }

                if(dict.containsKey(j)){
                    cumsum+=dict.get(j);
                }
            }

            dict = new_dict;
            cumsum=0;
        }

        int result =0;
        for(int i : dict.keySet()){
            result+=dict.get(i);
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(new Distinct_Subsequences().numDistinct_DP("rabbbit","rabbit"));
    }
}