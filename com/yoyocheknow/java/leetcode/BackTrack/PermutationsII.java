package leetcode.BackTrack;

import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer> counter = new HashMap<>();
        for(int n:nums){
            if(!counter.containsKey(n)) {
                counter.put(n,1);
            }else{
                counter.put(n,counter.get(n)+1);
            }
        }
        List<List<Integer>> result = new ArrayList();

        backtrack(result,new ArrayList<>(),counter,nums);
        return result;
    }
    private void backtrack(List<List<Integer>> result ,List<Integer> temp,HashMap<Integer,Integer> counter,int[] nums){
        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(Map.Entry<Integer,Integer> entry:counter.entrySet()){
            int count = entry.getValue();
            if(count==0){
                continue;
            }
            else{
                temp.add(entry.getKey());
                entry.setValue(count-1);
                backtrack(result,temp,counter,nums);

                temp.remove(temp.size()-1);
                entry.setValue(count);
            }
        }
    }
    public static void main(String[] args){
        List<List<Integer>> result = new PermutationsII().permuteUnique(new int[]{1,1,2});
        for(int i=0;i< result.size();i++){
            for(int j=0;j<result.get(i).size();j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

}
