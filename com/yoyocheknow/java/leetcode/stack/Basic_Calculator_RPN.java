package leetcode.stack;

import java.util.*;

/**
 * 实现一个简单的计算器(逆波兰运算符表示法)
 *
 * @author zhihua on 2021/2/22
 */
public class Basic_Calculator_RPN {
    /**
     * 先根据表达式转化成逆波兰表达式，然后再根据逆波兰表达式计算即可。
     * @param s
     * @return
     */
    public int calculate(String s) {
        Deque<String> stack1 = new ArrayDeque<>();
        Deque<String> stack2= new ArrayDeque<>();
        s = s.trim();
        if (s.charAt(0) == '-')
            s = "0" + s;
        RPN(stack1,stack2,s);

        for(String c :stack2){
            System.out.print(c + " ");
        }
        System.out.println();
        /**
         * 计算逆波兰运算符
         * 借助一个辅助栈，从s2中左边弹出元素放入help辅助栈内。
         * 如果是数字则直接放入help内
         * 如果是运算符，则使用help的栈顶两个元素 按照此运算符进行运算。然后将结果压入help栈内。
         * 依次类推，直到遍历完整个s2栈。
         * 结果就是help的栈顶元素。
         */
        Deque<Integer> help = new ArrayDeque<>();
        while (!stack2.isEmpty()){
           if(stack2.peekLast().equals("+")){
               int a = help.pop();
               int b = help.pop();
               a=a+b;
               stack2.pollLast();
               help.push(a);
           }
           else if(stack2.peekLast().equals("-")){
               int a = help.pop();
               int b = help.pop();
               a=b-a;
               stack2.pollLast();
               help.push(a);
           }
            else if(stack2.peekLast().equals("*")){
               int a = help.pop();
               int b = help.pop();
               a=a*b;
               stack2.pollLast();
               help.push(a);
            }
            else if(stack2.peekLast().equals("/")){
               int a = help.pop();
               int b = help.pop();
               a=b/a;
               stack2.pollLast();
               help.push(a);
            }
            else{
               help.push(Integer.valueOf(stack2.pollLast()));
            }
        }
        return help.peek();
    }

    /**
     * 栈s1用于临时存储运算符,此运算符在栈内遵循越往栈顶优先级越高的原则
     * 栈s2用于输入逆波兰式
     * 总体思路：s1暂存运算符，但是要保证越到栈顶优先级越高，然后往s2中放入数字元素
     * 如果碰到遍历的运算符 优先级小于 s1的栈顶运算符优先级，那么就把s1的这些栈顶运算符号搬到s2中。
     * 如果碰见'(',')',先把左括号放置到s1中，等碰到右括号时，再把s1 的栈顶暂存的运算符 依次搬到s2中。
     * @param stack1
     * @param stack2
     * @param s
     */
    public void RPN(Deque<String> stack1,Deque<String> stack2,String s){
        char[] chars = s.toCharArray();
        //以下操作都是为了避免出现123+234 这种多位数字的情况，所以要先做好预处理
        List<String> sb = new ArrayList<>();
        sb.add(String.valueOf(chars[0]));
        for(int i=1;i<chars.length;i++){
            //如果上一个字符为数字，且当前也为数字,计算出一个新的数字并放到sb里面
            if(Character.isDigit(chars[i-1]) &&  Character.isDigit(chars[i])){
                int last = Integer.valueOf(sb.get(sb.size()-1));
                last =last*10;
                last = last + chars[i]-'0';
                sb.remove(sb.size()-1);
                sb.add(String.valueOf(last));
            }else{
                sb.add(String.valueOf(chars[i]));
            }
        }
        //# 表示最低优先级 ，减少stack1的判空
        stack1.push("#");
        for(int i=0;i<sb.size();i++){
            String c = sb.get(i);
            switch (c){
                //忽略空格
                case " ": break;
                //遇'(' 直接入栈1
                case "(" :
                    stack1.push(c); break;
                //遇见'(',则将距离栈s1栈顶的最近的'('之间的运算符，逐个出栈，依次压入栈s2，此时抛弃'('；
                case ")":
                    while (!stack1.peek().equals("(")){
                        stack2.push(stack1.pop());
                    }
                    stack1.pop();
                    break;
                //遇见以下运算符，分两种情况讨论：
                //1. 若当前栈s1的栈顶元素是'('，则将x直接压入栈s1；
                //2. 若当前栈s1的栈顶元素不为'('，则将x与栈s1的栈顶元素比较，
                //若x的优先级大于栈s1栈顶运算符优先级，则将x直接压入栈s1。
                //否则，将栈s1的栈顶运算符弹出，压入栈s2中，直到栈s1的栈顶运算符优先级别低于x的优先级，或栈s2的栈顶运算符为'('，此时再则将x压入栈s1
                case "+":
                case "-":
                case "*":
                case "/":
                    if(stack1.peek().equals("(")){
                        stack1.push(c);
                    }
                    else{
                        if(getPriority(c)>getPriority(stack1.peek())){
                            stack1.push(c);
                        }else{
                            while (getPriority(stack1.peek())>=getPriority(c)|| stack2.peek().equals("(")){
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
        while (!stack1.isEmpty() && !stack1.peek().equals("#")){
            stack2.push(stack1.pop());
        }
    }

    public int getPriority(String c){
        switch (c){
            case "#":
                return 0;
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            default:return 0;
        }
    }

    public static void main(String[] args){
        String s = "(1+2)*3-(2+4)/3";
//        String s  ="-2+1";
        System.out.println(new Basic_Calculator_RPN().calculate(s));
    }
}