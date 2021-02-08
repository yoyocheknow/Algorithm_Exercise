package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 找到数组中每一个元素右边的第一个最大值
 * 利用栈，存放array的下标
 * 每当array[i]>栈顶元素时，记录此结果。result[stack.pop()] = array[i]
 * 当array[i]<=栈顶元素时，把下标i压入栈。
 * 最后看看栈里面存放的数值i，说明这些下标i，都没有右边比它大的元素。
 * @author zhihua on 2021/2/8
 */
public class Find_the_Right_Max {

    public int[] findMaxRightWithStack(int[] array) {
        if(array == null) {
            return array;
        }
        int size = array.length;
        int[] result = new int[size];
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while(i < size) {
            if(stack.isEmpty() || array[i] <= array[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                result[stack.pop()] = array[i];
            }
        }
        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static void main(String[] args){
        int [] array = new int[]{4, 3, 4,  5, 1,  2};
        int []res = new Find_the_Right_Max().findMaxRightWithStack(array);
        for(int num:res){
            System.out.print(num+" ");
        }
    }
}