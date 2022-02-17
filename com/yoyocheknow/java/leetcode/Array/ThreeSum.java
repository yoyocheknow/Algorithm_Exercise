package leetcode.Array;

import java.util.*;

/**
 * 3Sum
 *
 * @author zhihua on 2020/11/3
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum2(int[] nums,int target) {
        Set<List<Integer>> result = new HashSet<>();
        if(nums.length<3){
            return new ArrayList();
        }
        //排序
        nums = Arrays.stream(nums).sorted().toArray();

        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j< nums.length-1;j++){
                List<Integer> temp = new ArrayList();
                temp.add(nums[i]);
                temp.add(nums[j]);
                map.put(-nums[i] - nums[j],j);
                for(int k=j+1;k< nums.length;k++){
                    if(map.containsKey(nums[k])){
                        temp.add(nums[k]);
                        result.add(temp);
                        map.clear();
                        break;
                    }
                }
                map.clear();
            }
        }

        return new ArrayList<>(result);
    }


    public static List<List<Integer>> threeSum(int[] nums,int target) {
        Set<List<Integer>> result =new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int sum = target-nums[i];
            HashMap<Integer, Integer> map = new HashMap();

            for(int j =i+1;j<nums.length;j++){

                if(!map.containsKey(nums[j])){
                    map.put(sum-nums[j],j);
                }else{
                    result.add(Arrays.asList(nums[i],nums[map.get(nums[j])],nums[j]));
                }
            }
        }

        return new ArrayList<>(result);

    }

    public static List<List<Integer>> threeSum1(int[] nums,int target) {
        Set<List<Integer>> result =new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right =nums.length-1;

            while(left<right){
                if(nums[i]+nums[left]+nums[right]==target){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                }
                else if(nums[i]+nums[left]+nums[right]<target){
                   left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(result);

    }
    public static void main(String[] args){
        int[] nums = new int[]{-4,-2,-1,0,2,4,5};
        List<List<Integer>> result = threeSum1(nums,3);
        result.stream().forEach(System.out::println);
    }
}