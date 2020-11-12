package leetcode.Greedy;

import java.util.Arrays;

/**
 * 分糖果
 *
 * @author zhihua on 2020/11/12
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        //g[]数组代表孩子  s[]数组代表糖果
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0;
        int r=0;
        int count=0;
        while(l<g.length && r<s.length){
            if(g[l]<=s[r]){
                count++;
                l++;
                r++;
            }else{
                r++;
            }
        }
        return count;
    }
}


