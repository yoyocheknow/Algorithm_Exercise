package leetcode.BackTrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 组合
 *
 * @author zhihua on 2020/11/23
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List array = new ArrayList();
        for(int i=0;i<n;i++){
            array.add(i+1);
        }
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();
        backTrack(array,temp,result,0,k);
        return result;
    }

    public void backTrack(List<Integer> array, List<Integer> temp,List<List<Integer>>result,int start,int k){
        if(temp.size()==k){
            List<Integer> dest = new ArrayList<>();
            dest.addAll(temp);
            result.add(dest);
            return;
        }
        for(int i=start;i<array.size();i++){
            temp.add(array.get(i));
            backTrack(array,temp,result,i+1,k);
            temp.remove(temp.size()-1);
        }
        return;

    }

    public static void main(String[] args){
        Combinations c = new Combinations();
        System.out.println(c.combine(3,2).toString());
    }
}