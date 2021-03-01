package leetcode.DP;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最长有效括号
 *
 * @author zhihua on 2021/3/1
 */
public class Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        if(chars.length<1){
            return 0;
        }
        int result=0;
        Deque<Integer> stack = new ArrayDeque<>();
        //stack 先加-1，是辅助第一组左右括号为前两个字符的情况，这样可以方便计算出括号长度。
        stack.push(-1);
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                stack.push(i);
            }else{
                stack.pop();
                //当stack为空时，需要把i push进去。此时i是一个右括号的下标，代表着上一个连续合法括号的位置。
                //这个判断空很关键，这个是计算连续长度的关键一步
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    int max = i-stack.peek();
                    result=Math.max(result,max);
                }
            }
        }

        return result;
    }
    public static void main(String[] args){
        System.out.println(new Longest_Valid_Parentheses().longestValidParentheses("()()"));
    }
}