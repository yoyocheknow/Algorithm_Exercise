package leetcode.String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最长有效运算符
 * ")()())"--4
 * "(()"--2
 * "(())"--4
 * "()(()"--2
 * @author zhihua on 2020/12/22
 */
public class Longest_Valid_Parentheses {
    /**
     * 栈里面存放运算符的下标
     * 当字符为'('时，直接入栈其下标
     * 当字符为')'时，弹出栈顶元素，判断此时栈是否为空。若不为空，则说明此时的运算符和前面的不连续，此时要找到最大的合法长度max。此时栈顶元素保存的时上一次合法运算符串的末尾下标。
     * i-stack.peekFirst()即得出本次连续运算符的长度。
     * 若此时栈为空，则继续将此')'的下标入栈。代表一个合法运算符完成。
     *
     */
    public int longestValidParentheses(String s) {
        int max=0;
        Deque<Integer> stack = new ArrayDeque();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')'){
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max,i-stack.peekFirst());
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(new Longest_Valid_Parentheses().longestValidParentheses("(())"));
    }



}