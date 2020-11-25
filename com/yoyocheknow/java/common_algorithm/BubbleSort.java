package common_algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 冒泡排序
 *
 * @author zhihua on 2020/11/25
 */
public class BubbleSort {
    /**
     * 普通写法
     *
     */
    public void bubbleSort1(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp;
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
    }

    /**
     * 优化写法
     * 如果某一趟没有发生任何交换，说明已经有序，无需再进行排序
     */
    public void bubbleSort2(int[] array){

        for(int i=0;i<array.length-1;i++){
            Boolean swap=false;
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    swap = true;
                    int temp;
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
            if(!swap){
                break;
            }
        }
    }

    /**
     * 再优化写法
     * 比如某一趟排序后的序列为4，2，1，5，6，8
     * 5，6，8其实已经是有序的了，后面不需要再进行比较。
     * 这是就要记录一个最大的边界值lastSwapIndex代表后面都是有序的。
     * 当一趟排序过后，lastSwapIndex没有改变，说明后面就是有序的。
     */
    public void bubbleSort3(int[] array){
        int lastSwapIndex=array.length-1;
        int border = array.length-1;
        for(int i=0;i<array.length-1;i++){
            Boolean swap=false;
            for(int j=0;j<border;j++){
                if(array[j]>array[j+1]){
                    swap = true;
                    lastSwapIndex =j;
                    int temp;
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
            border = lastSwapIndex;
            if(!swap){
                break;
            }
        }
    }

    /**
     * 使用两个栈的写法
     * 给定两个栈 s1 和 s2 ，以及一个长度为 n 的数组 arr :
     * 1，将数组 arr 中的所有元素压入栈 s1 当中；
     * 执行 for 循环 n 次（每一次选择出一个最大的元素）：
     * 情况一：s1 不为空，s2 为空，则尝试将栈 s1 当中的所有元素压入栈 s2 ，并保证 s2 的栈顶元素为最大值；当 s1 为空时，s2 中的栈顶元素即为栈中元素的最大值，插入数组相应位置。
     * 情况二：s2 不为空，s1 为空，则尝试将栈 s2 当中的所有元素压入栈 s1 ，并保证 s1 的栈顶元素为最大值；当 s2 为空时，s1 中的栈顶元素即为栈中元素的最大值，插入数组相应位置。
     */
    public void bubbleSort4(int[] array){
        Deque<Integer> stack1 =new ArrayDeque();
        Deque<Integer> stack2 = new ArrayDeque();
        int n =array.length;
        for(int i=0;i<n;i++){
            stack1.push(array[i]);
        }
        for(int i=0;i<n;i++){
            if(i%2==0){
                while (!stack1.isEmpty()){
                    if(stack1.size()==1) break;
                    if(stack2.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                    if(!stack2.isEmpty()){
                        if(stack1.isEmpty()){
                            break;
                        }
                        if(stack2.peek()>stack1.peek()){
                            int temp =stack2.pop();
                            stack2.push(stack1.pop());
                            stack2.push(temp);
                        }
                        else stack2.push(stack1.pop());
                    }
                }
                //此时stack2的peek数据即为最大值
                array[n-i-1]=stack2.pop();
            }
            if(i%2!=0){
                while (!stack2.isEmpty()){
                    if(stack1.isEmpty()){
                        stack1.push(stack2.pop());
                    }
                    if(!stack1.isEmpty()){
                        if(stack2.isEmpty()){
                            break;
                        }
                        if(stack1.peek()>stack2.peek()){
                            int temp =stack1.pop();
                            stack1.push(stack2.pop());
                            stack1.push(temp);
                        }
                        else stack1.push(stack2.pop());
                    }
                }
                //此时stack1的peek数据即为最大值
                array[n-i-1]=stack1.pop();
            }
        }
    }
    public static void main(String[] args){
        int [] array = new int[]{5,1,4,2,8,4};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort4(array);
        Arrays.stream(array).forEach(System.out::print);
    }
}