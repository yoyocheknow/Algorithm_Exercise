package leetcode.Array;

import java.util.Arrays;

public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1){
            return "";
        }
        for(int j=0;j<strs[0].length();j++){
            char c = strs[0].charAt(j);
            for(int i=1;i<strs.length;i++){
                if(j == strs[i].length() || strs[i].charAt(j)!=c){
                    return strs[0].substring(0,j);
                }
            }

        }

        return strs[0];
    }
    public static void main(String[] args){
        Longest_Common_Prefix longestCommonPrefix = new Longest_Common_Prefix();
        System.out.print(longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
