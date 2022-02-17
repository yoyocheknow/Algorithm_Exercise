package leetcode.BackTrack;

import java.lang.reflect.Array;
import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();

        backtrack(result,new ArrayList<>(),nums);
        return result;
    }
    private void backtrack(List<List<Integer>> result ,List<Integer> temp,int[] nums){
        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
        }
        for(int n:nums){
            if(temp.contains(n)) continue;
            temp.add(n);
            backtrack(result,temp,nums);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args){
        List<List<Integer>> result = new Permutations().permute(new int[]{1,2,3});
        for(int i=0;i< result.size();i++){
            for(int j=0;j<result.get(i).size();j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
