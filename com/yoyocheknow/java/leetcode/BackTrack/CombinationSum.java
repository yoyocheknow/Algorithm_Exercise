package leetcode.BackTrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 和的组合
 *
 * @author zhihua on 2020/11/27
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet();
        backtrack(result,new ArrayList(),candidates,0,target,0);

        return new ArrayList(result);
    }
    private void backtrack(Set<List<Integer>> result,List<Integer> temp,int[] candidates,int sum, int target,int start){
        if(sum==target){
            result.add(new ArrayList(temp));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(result,temp,candidates,sum+candidates[i],target,i);
            temp.remove(temp.size()-1);
        }

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