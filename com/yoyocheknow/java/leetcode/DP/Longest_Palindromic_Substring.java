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
     * 定义p(i,j) : true (如果子串si...sj是回文)
     *             false
     * 因此 p(i,j) = (p(i+1,j-1)&&si==sj)
     * 初始化：p(i,j)=true
     *        p(i,i+1)=(si==si+1)
     */
    public String longestPalindromeDP(String s) {
        if(s.length()==1){
            return s;
        }
        boolean [][]dp =new boolean[s.length()+1][s.length()+1];
        dp[0][0]=true;
        for(int i=1;i<s.length()-1;i++){
            dp[i][i]=true;
            dp[i][i+1] = s.charAt(i)==s.charAt(i+1);
            for(int j=i;j<s.length()-1;j++){
                dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        return rex;
    }
    public static void main(String[] args){
        Longest_Palindromic_Substring longest_palindromic_substring =new Longest_Palindromic_Substring();
        System.out.println(longest_palindromic_substring.longestPalindromeDP("babad"));
    }
}