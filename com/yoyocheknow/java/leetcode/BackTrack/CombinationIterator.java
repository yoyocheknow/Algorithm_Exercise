package leetcode.BackTrack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 设计一个组合迭代器
 *
 * @author zhihua on 2020/11/29
 */
public class CombinationIterator {
    public Deque<String> stack;
    public CombinationIterator(String characters, int combinationLength) {
        this.stack = new ArrayDeque<>();
        char[] chars = characters.toCharArray();
        backTrack(stack,combinationLength,"",chars,0);

    }

    public void backTrack(Deque stack,int n,String temp,char[] chars,int start){
        if(temp.length()==n){
            stack.push(temp);
            return;
        }
        for(int i=start;i<chars.length;i++){
            backTrack(stack,n,temp+ chars[i],chars,i+1);
        }

    }

    public String next() {
        if(!stack.isEmpty()){
            return stack.pollLast();
        }
        return "";
    }

    public boolean hasNext() {
        if(stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[]args){
        CombinationIterator combinationIterator = new CombinationIterator("abc",2);
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
    }
}