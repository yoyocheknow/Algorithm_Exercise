package leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 和之组合III
 *
 * @author zhihua on 2020/11/28
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backTrack(k,n,result,temp,0,1);
        return result;
    }

    public void backTrack(int k,int n,List<List<Integer>> result,List<Integer> temp,int sum,int start){
        if(temp.size()==k && sum==n){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(temp.size()>k){
            return;
        }
        for(int i=start;i<=9;i++){
            if(sum>n){
                break;
            }
            temp.add(i);
            backTrack(k,n,result,temp,sum+i,i+1);
            temp.remove(temp.size()-1);
        }

    }

    public static void  main(String[] args){
        CombinationSumIII combinationSumIII=new CombinationSumIII();
        List<List<Integer>> result = combinationSumIII.combinationSum3(2,18);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i).toString());
        }
    }
}