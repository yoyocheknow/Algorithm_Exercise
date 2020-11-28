package leetcode.BackTrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 和之组合II
 *
 * @author zhihua on 2020/11/28
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(candidates,target,result,temp,0,0);
        return result;
    }
    public void backTrack(int[] candidates, int target,List<List<Integer>> result,List<Integer> temp,int sum,int startIndex){
        if(sum==target){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            if(sum>target) {
                break;
            }
            //防止出现重复的子序列
            if(i>startIndex&&candidates[i]==candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            backTrack(candidates,target,result,temp,sum+candidates[i],i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args){
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] array = new int[]{2,5,2,1,2};
        int target = 5;
        List<List<Integer>> result = combinationSumII.combinationSum2(array,target);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i).toString());
        }

    }
}