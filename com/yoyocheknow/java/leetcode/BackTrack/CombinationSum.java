package leetcode.BackTrack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 和的组合
 *
 * @author zhihua on 2020/11/27
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(0,target,result,new ArrayList<>(),candidates);
        return result;
    }

    public void backTrack(int start,int target,List<List<Integer>> result,List<Integer>temp,int[] candidates){
        if(getSum(temp)==target){
            List<Integer> r = new ArrayList<>();
            r.addAll(temp);
            result.add(r);
            return;
        }
        if(getSum(temp)<target){
            for(int i=start;i<candidates.length;i++){
                temp.add(candidates[i]);
                backTrack(i,target,result,temp,candidates);
                temp.remove(temp.size()-1);
            }
        }
        return;

    }

    public int getSum(List<Integer> temp){
        int sum =0;
        for(int i=0;i<temp.size();i++){
            sum+=temp.get(i);
        }
        return sum;
    }

    public static void main(String[] args){
        CombinationSum cs =new CombinationSum();
        int[] candidates =new int[]{2,3,6,7};

        List<List<Integer>> result = cs.combinationSum(candidates,7);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i).toString());
        }
    }

}