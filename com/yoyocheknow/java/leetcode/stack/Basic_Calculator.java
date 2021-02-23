package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 设计一个简单计算器
 * 前提：只有加减运算，有括号
 * 1，将字符串逆序放到栈中。
 * 如果正序操作比如（7-8+9） 放入栈的形式为： [(,7,-,8,+,9]
 * 当遍历到')' 时，开始弹出元素计算： pop 9,pop +,pop 8, evaluate 9+8 =17 ,push 17
 * 目前栈元素为：[(,7,-,17]
 * 最后再次弹出计算： pop 17,pop - ,pop 7,evaluate 17-7 =10
 * 结果明显不对。所以我们采取逆序的方式放入。
 * 此次放入栈的形式为 [),9,+,8,-,7]
 * 当遍历到 '('时，开始弹出元素计算：pop 7,pop -, pop 8, evaluate 7-8=-1,push -1
 * 目前栈元素为：[),9,+,-1]
 * 最后再次弹出计算：pop -1,pop +,pop 9 ,evaluate -1+8=7,push 7
 * 得到最后结果
 * @author zhihua on 2021/2/23
 */

public class Basic_Calculator {
    /**
     * 计算栈存放的数据
     * @param stack
     * @return
     */
    public int evaluateExpr(Deque stack){
        int res = 0;
        if(!stack.isEmpty()){
            res = (int) stack.pop();
        }
        //如果栈顶元素不为')'
        while(!stack.isEmpty() && !((char)stack.peek() == ')')){
            char sign = (char)stack.pop();
            if(sign =='+'){
                res += (int)stack.pop();
            }else{
                res -= (int)stack.pop();
            }
        }
        return res;
    }

    public int calculate(String s) {
        int operand = 0;
        int n =0;
        s = s.trim();
        if (s.charAt(0) == '-')
            s = "0" + s;

        Deque stack = new ArrayDeque();
        for(int i =s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            //防止出现 123+234这种情况，因为是单个遍历字符。
            if(Character.isDigit(ch)){
                operand = (int) Math.pow(10,n)*(int)(ch-'0')+operand;
                n+=1;
            }
            else if(ch != ' '){
                if(n!=0){
                    //如果当前字符为运算符，那么就把上次计算的数字push到栈中。幂指数归零
                    stack.push(operand);
                    n=0;
                    operand=0;
                }
                if(ch == '('){
                    int res = evaluateExpr(stack);
                    stack.pop();
                    stack.push(res);
                }else{
                    stack.push(ch);
                }
            }
        }
        if(n!=0){
            stack.push(operand);
        }
        return evaluateExpr(stack);
    }

    public static void main(String[] args){
        System.out.println(new Basic_Calculator().calculate("-2+1"));
    }
}