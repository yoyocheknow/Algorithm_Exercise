package leetcode.DP;

/**
 * 最长回文子串
 *
 * @author zhihua on 2020/11/30
 */
public class Longest_Palindromic_Substring {
    int  max=0;
    String rex = "";
    public String longestPalindrome(String s) {
        if (s.length() == 1) { return s; }
        int length =s.length();
        for(int i=0;i<length-1;i++)
        {
            isPalindromic3(s,i,i);
            isPalindromic3(s,i,i+1);
        }
        return rex;
    }
    /**
     * 从中心向外扩展思路
     *
     */
    public  void isPalindromic3(String s,int low,int high)
    {
        while (low>=0&&high<s.length())
        {
            if(s.charAt(low)==s.charAt(high))
            {
                if(high-low+1>max)
                {
                    max=high-low+1;
                    rex=s.substring(low,high+1);
                }
                low--;
                high++;
            }else
                return;

        }
    }
    /**
     * DP思想
     * dp[i][j]表示 si...sj 是否是回文
     * 因此dp[i][j] = (dp[i+1][j-1] && si==sj)
     * 初始化：dp[i][j]=true
     *        dp[i][i+1]=(si==si+1)
     */
    public String longestPalindromeDP(String s) {
        if(s.equals("") || s.length()==1){
            return s;
        }
        int maxlength = 0;
        int left=0;
        int right = 0;
        boolean [][]dp =new boolean[s.length()][s.length()];

        //j为右边界，i为左边界
        for(int j=0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                if(i+1<=j-1)
                    dp[i][j] =  dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
                else
                    dp[i][j] = s.charAt(i)==s.charAt(j);

                if(dp[i][j] && j-i>maxlength){
                    maxlength=j-i;
                    left=i;
                    right=j;
                }
            }
        }

        return s.substring(left,right+1);
    }
    public static void main(String[] args){
        Longest_Palindromic_Substring longest_palindromic_substring =new Longest_Palindromic_Substring();
        System.out.println(longest_palindromic_substring.longestPalindromeDP("aba"));
    }
}