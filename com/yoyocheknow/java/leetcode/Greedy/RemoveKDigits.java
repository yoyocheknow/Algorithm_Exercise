package leetcode.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 移除K个数字
 *
 * @author zhihua on 2020/11/14
 */
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {

        char[] nums=num.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< nums.length;i++){
            int value = Integer.valueOf(nums[i]-'0');
            while(stack.size()>0&&k>0 && value<stack.peek()){
                stack.pop();
                k--;
            }
            if(value==0 && stack.size()==0){
                continue;
            }
            stack.push(value);

        }
        while(stack.size()!=0 && k>0){
            stack.pop();
            k--;
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        result.stream().forEach(item->sb.append(item));
        if(sb.toString().equals("")){
            return "0";
        }
        return sb.toString();

    }
    public static void main(String  args[]){
        System.out.println(removeKdigits("12345",3));
    }
}