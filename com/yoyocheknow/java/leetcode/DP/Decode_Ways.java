package leetcode.DP;

/**
 * 揭秘方法
 * 动态规划套路 类似与爬楼梯
 * dp[i] 表示截止到当前第i个元素时有几种情况
 * 初始化dp[0]=1;
 * 当前元素有两种情况，包含在前一个数字里面或者单独是一个数字。这个数字范围是1<=x<=26
 * 也就是说当这个元素和前面一个元素组成的数字在[1,26]之间时，那么就可以包含。如果单独出来在[1,26]之间时也可以单独出来。
 * 每次dp[i]都会依赖dp[i-1]的值
 * 转移方程，dp[i] = if 1<=(i-1 i)<=26 ,dp[i-1]
 *                 if 1<=i<=26, dp[i-1]+1
 * @author zhihua on 2021/3/4
 */
public class Decode_Ways {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if(chars.length<1){
            return 0;
        }
        int[] ints = new int[chars.length];
        for(int i=0;i<chars.length;i++){
            ints[i] = chars[i]-'0';
        }

        int[] dp = new int[chars.length+1];
        dp[0]=1;

       for(int i=1;i<=ints.length;i++){
           int value = ints[i-1];
           //当前字符大于0的话，那么就可以独立出来，相当于拆分出来，属于同一种情况，dp[i]=dp[i-1]
           if(value>=1){
               dp[i]=dp[i-1];
           }

           if(i>1){
              int pre = ints[i-2];
              int add = pre*10+value;
               /**
                * 如果当前字符和前面的字符可以合在一起，并且10<=add<=26(为什么是>=10呢？因为这样说明前一个字符是非零字符。零字符的话，不能和前一个字符合并)
                * 可以合并在一起，那么dp[i] = dp[i]+dp[i-2] ,其实此时有两种情况：
                * 1，当前元素=0，那么只能依附上一个元素。此时依赖dp[i-2]
                * 2，当前元素!=0，那么当前元素还可以单独拆出来.此时依赖 dp[i-1]。这个情况其实在循环开始就已经判断了。
                * 所以 dp[i] = dp[i]+dp[i-2]
                */
              if(10<=add && add<=26){
                  dp[i]=dp[i]+dp[i-2];
              }

           }
       }
        return dp[chars.length];

    }

    public static void main(String[] args){
        System.out.println(new Decode_Ways().numDecodings("01"));
    }
}