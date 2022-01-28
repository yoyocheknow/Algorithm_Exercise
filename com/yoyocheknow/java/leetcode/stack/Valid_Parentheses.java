package leetcode.stack;

import java.util.Stack;

public class Valid_Parentheses {
    public boolean isValid(String s) {
        if(s.length()<1){
            return true;
        }
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='(' || chars[i]=='{' || chars[i]=='['){
                stack.push(chars[i]);
            }
            else if(chars[i]==')' && !stack.empty()&& (Character) stack.peek()=='('){
                stack.pop();
            }
            else if(chars[i]=='}' && !stack.empty()&& (Character) stack.peek()=='{'){
                stack.pop();
            }
            else if(chars[i]==']' && !stack.empty()&& (Character) stack.peek()=='['){
                stack.pop();
            }else{
                stack.push(chars[i]);
            }
        }
        return stack.empty();
    }
    public static void main(String[] args){
        System.out.print(new Valid_Parentheses().isValid("(())"));
    }
}
