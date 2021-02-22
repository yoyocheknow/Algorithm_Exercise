package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 实现一个简单的计算器
 *
 * @author zhihua on 2021/2/22
 */
public class Basic_Calculator {
    /**
     * 先根据表达式转化成逆波兰表达式，然后再根据逆波兰表达式计算即可。
     * @param s
     * @return
     */
    public int calculate(String s) {
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2= new ArrayDeque<>();
        RPN(stack1,stack2,s);
        while (!stack2.isEmpty()){
            System.out.print(stack2.pollLast() + " ");
        }
        return 1;
    }

    /**
     * 栈s1用于临时存储运算符,此运算符在栈内遵循越往栈顶优先级越高的原则
     * 栈s2用于输入逆波兰式
     * 总体思路：s1暂存运算符，但是要保证越到栈顶优先级越高，然后往s2中放入数字元素
     * 如果碰到遍历的运算符 优先级小于 s1的栈顶运算符优先级，那么就把s1的这些栈顶运算符号搬到s2中。
     * 如果碰见'(',')',先把左括号放置到s1中，等碰到右括号时，再把s1 的栈顶暂存的运算符 以此搬到s2中。
     * @param stack1
     * @param stack2
     * @param s
     */
    public void RPN(Deque<Character> stack1,Deque<Character> stack2,String s){
        char[] chars = s.toCharArray();
        //# 表示最低优先级 ，减少stack1的判空
        stack1.push('#');
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            switch (c){
                //遇'(' 直接入栈1
                case '(' :
                    stack1.push(c); break;
                //遇见'(',则将距离栈s1栈顶的最近的'('之间的运算符，逐个出栈，依次压入栈s2，此时抛弃'('；
                case ')':
                    while (stack1.peek()!='('){
                        stack2.push(stack1.pop());
                    }
                    stack1.pop();
                    break;
                //遇见以下运算符，分两种情况讨论：
                //1. 若当前栈s1的栈顶元素是'('，则将x直接压入栈s1；
                //2. 若当前栈s1的栈顶元素不为'('，则将x与栈s1的栈顶元素比较，
                //若x的优先级大于栈s1栈顶运算符优先级，则将x直接压入栈s1。
                //否则，将栈s1的栈顶运算符弹出，压入栈s2中，直到栈s1的栈顶运算符优先级别低于x的优先级，或栈s2的栈顶运算符为'('，此时再则将x压入栈s1
                case '+':
                case '-':
                case '*':
                case '/':
                    if(stack1.peek()=='('){
                        stack1.push(c);
                    }
                    else{
                        if(getPriority(c)>getPriority(stack1.peek())){
                            stack1.push(c);
                        }else{
                            while (getPriority(stack1.peek())>=getPriority(c)|| stack2.peek()=='('){
                                stack2.push(stack1.pop());
                            }

                            stack1.push(c);
                        }
                    }
                    break;
                default:
                    stack2.push(c);
                    break;

            }
        }
        while (!stack1.isEmpty() && stack1.peek()!='#'){
            stack2.push(stack1.pop());
        }
    }

    public int getPriority(char c){
        switch (c){
            case '#':
                return 0;
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default:return 0;
        }
    }

    public static void main(String[] args){
        new Basic_Calculator().calculate("(a+b)*c-(a+b)/e");
    }
}