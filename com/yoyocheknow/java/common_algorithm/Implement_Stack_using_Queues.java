package common_algorithm;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 使用两个队列实现一个栈
 *
 * @author zhihua on 2020/12/11
 */
public class Implement_Stack_using_Queues {
    //queue1作为栈，queue2作为辅助
    //push时，每次将元素放到queue1中
    //pop时，将queue1 中size-1个元素弹出到queue2中，然后弹出queue1的最后一个元素，即为栈顶元素
    //然后queue2和queue1交换。
    Queue<Integer> queue1 ;
    //queue2 as the assist
    Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public Implement_Stack_using_Queues() {
        queue1 = new PriorityQueue();
        queue2 = new PriorityQueue();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(queue1.size()>1){
            queue2.add(queue1.poll());
        }
        //queue1只保留最后一个元素，也就是栈顶元素
        int x = queue1.poll();

        //然后再把queue2的元素回填到queue1中，相当于queue1和queue2交换
        while (!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        return x;
    }

    /** Get the top element. */
    public int top() {
        while(queue1.size()>1){
            queue2.add(queue1.poll());
        }
        int x = queue1.peek();

        queue2.add(queue1.poll());
        while (!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        return x;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args){
        Implement_Stack_using_Queues myStack = new Implement_Stack_using_Queues();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}