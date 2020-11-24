package leetcode.BackTrack;

import com.sun.tools.javac.util.StringUtils;

import java.util.*;

/**
 * 电话号码字母的组合
 *
 * @author zhihua on 2020/11/23
 */
public class Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {

        char[] nums = digits.toCharArray();
        List<String> result = new ArrayList<>();
        if(nums.length<1){
            return result;
        }
        Map<Character,List<String>> charMap = new HashMap();
        charMap.put('2', Arrays.asList("a","b","c"));
        charMap.put('3', Arrays.asList("d","e","f"));
        charMap.put('4', Arrays.asList("g","h","i"));
        charMap.put('5', Arrays.asList("j","k","l"));
        charMap.put('6', Arrays.asList("m","n","o"));
        charMap.put('7', Arrays.asList("p","q","r","s"));
        charMap.put('8', Arrays.asList("t","u","v"));
        charMap.put('9', Arrays.asList("w","x","y","z"));
        backTrack("",nums,result,charMap);
        return result;
    }

    public void backTrack(String sb,char[] nums ,List<String> result ,Map<Character,List<String>> charMap ){
        if(nums.length==0){
            result.add(sb);
            return;
        }
        for(int i=0;i<charMap.get(nums[0]).size();i++){
            backTrack(sb+charMap.get(nums[0]).get(i),Arrays.copyOfRange(nums,1,nums.length),result,charMap);
        }

    }

    public static void main(String[] args){
        System.out.println(new Letter_Combinations_of_a_Phone_Number().letterCombinations("237"));
    }
}