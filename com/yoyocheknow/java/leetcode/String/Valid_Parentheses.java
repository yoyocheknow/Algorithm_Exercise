package leetcode.String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 有效的运算符
 *
 * @author zhihua on 2020/12/22
 */
public class Valid_Parentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('||chars[i]=='['||chars[i]=='{'){
                stack.push(chars[i]);
            }
            else if(!stack.isEmpty()){
                char peek = stack.pop();
                if(chars[i]==')' && peek!='('){
                    return false;
                }
                if(chars[i]==']' && peek!='['){
                    return false;
                }
                if(chars[i]=='}' && peek!='{'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(new Valid_Parentheses().isValid("]"));
    }
}