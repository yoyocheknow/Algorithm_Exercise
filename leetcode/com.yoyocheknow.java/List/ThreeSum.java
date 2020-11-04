package List;

import java.util.*;

/**
 * 3Sum
 *
 * @author zhihua on 2020/11/3
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result =new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int sum = 0-nums[i];
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

    public static List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> result =new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right =nums.length-1;

            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                }
                else if(nums[i]+nums[left]+nums[right]<0){
                   left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(result);

    }
    public static void main(String[] args){
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum1(nums);
        result.stream().forEach(System.out::println);
    }
}