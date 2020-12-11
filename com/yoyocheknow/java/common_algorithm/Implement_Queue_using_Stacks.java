package common_algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用两个栈实现队列
 *
 * @author zhihua on 2020/12/11
 */
public class Implement_Queue_using_Stacks {
    public Deque<Integer> stack1;
    public Deque<Integer> stack2;
    /** Initialize your data structure here. */
    public Implement_Queue_using_Stacks() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack2.isEmpty() && stack1.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Implement_Queue_using_Stacks myQueue = new Implement_Queue_using_Stacks();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty());// return false
    }
}