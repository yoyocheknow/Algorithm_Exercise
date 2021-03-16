package leetcode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文分隔
 *
 * @author zhihua on 2021/3/13
 */
public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        List<List<String>> res = new ArrayList<>();
        backtrack(s,0,chars.length-1,new ArrayList<>(),res);
        return res;
    }

    public void backtrack(String s,int l,int r,List<String> temp,List<List<String>> res){
        if(l==r+1){
            res.add(new ArrayList<>(temp));
            return ;
        }
        for(int k=l;k<=r;k++){
            if(isPalindrome(s.substring(l,k+1))){
                temp.add(s.substring(l,k+1));
                backtrack(s,k+1,r,temp,res);
                temp.remove(temp.size()-1);
            }

        }
    }

    public boolean isPalindrome(String s){
        char[] chars =s.toCharArray();
        int l = 0;
        int r = chars.length-1;
        while (l<r){
            if(chars[l]!=chars[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /**
     * 带有DP缓存的回溯法
     * 假设字符串s有两个左右指针 l,r
     * dp[l][r]=true 表示字符串s[l..r] 是一个回文。那么如果dp[l][r]如果为true，即表示
     * dp[l+1][r-1]为true，且s[l]==s[r].
     * 所以可以把这些结果缓存起来，回溯使用。
     * @param s
     * @return
     */
    public List<List<String>> partition1(String s) {
        int len = s.length();
        boolean[][]dp = new boolean[len][len];
        List<List<String>> res = new ArrayList<>();
        dfs(res,s,0,new ArrayList<>(),dp);
        return res;
    }
    public void dfs(List<List<String>>res, String s,int l,List<String>temp,boolean[][] dp){
        if(l>=s.length()){
            res.add(new ArrayList<>(temp));
        }

        for(int r=l;r<s.length();r++){
            if(s.charAt(l)==s.charAt(r) && (r-l<=2 || dp[l+1][r-1])){
                dp[l][r]=true;
                temp.add(s.substring(l,r+1));
                dfs(res, s, r+1, temp, dp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args){
        List<List<String>> res = new Palindrome_Partitioning().partition1("aab");
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}