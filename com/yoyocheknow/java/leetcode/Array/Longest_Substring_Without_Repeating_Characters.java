package leetcode.Array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 不包含重复字符的最长子串
 *
 * @author zhihua on 2020/12/21
 */
public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1){
            return 0;
        }
        char[] chars = s.toCharArray();
        int low =0;
        int high = 0;
        HashSet<Character> slide_window = new HashSet();
        int max = 0;
        while(low<chars.length && high<chars.length){
            if(!slide_window.contains(chars[high])){
                slide_window.add(chars[high]);
                high++;
                max = Math.max(max,high-low);
            }else{
                slide_window.remove(chars[low]);
                low++;
            }
        }
        return  max;
    }


    public static void main(String[] args){
        System.out.println(new Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("pwwkew"));
    }
}