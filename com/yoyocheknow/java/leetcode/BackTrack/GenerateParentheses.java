package leetcode.BackTrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 生成括号
 *
 * @author zhihua on 2020/11/24
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        List<String> s = new ArrayList<>();
        backTrack2(result,n,"",0,0);
        return result;
    }

    public void backTrack(List<String> result,int n,List<String> s){
        if(s.size()==2*n){
            StringBuilder sb=new StringBuilder();
            s.stream().forEach(item->{
                sb.append(item);
            });
            result.add(sb.toString());
            return;
        }


        if(getChar(s,"(")<n){
            s.add("(");
            backTrack(result,n,s);
            s.remove(s.size()-1);
        }
        if(getChar(s,"(")>getChar(s,")")){
            s.add(")");
            backTrack(result,n,s);
            s.remove(s.size()-1);
        }

    }

    public void backTrack2(List<String> result,int n,String s,int left,int right){
        if(s.length()==2*n){
            result.add(s);
            return;
        }

        if(left<n){
            backTrack2(result,n,s+"(",left+1,right);
        }
        if(right<left){
            backTrack2(result,n,s+")",left,right+1);

        }

    }

    public int getChar(List<String> list,String s){
        int count =0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(s)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(new GenerateParentheses().generateParenthesis(3).toString());
    }
}