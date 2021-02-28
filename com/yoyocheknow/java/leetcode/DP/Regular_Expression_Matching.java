package leetcode.DP;

/**
 * 正则表达式匹配
 * '.' Matches any single character.​​​​ '.' 可以匹配任一字符
 * '*' Matches zero or more of the preceding element. '*' 可以匹配前面字符的0次或者多次
 * @author zhihua on 2021/2/28
 */
public class Regular_Expression_Matching {
    //回溯法
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }
        //如果s,p都不为空，并且当前字符相同或者 p当前为'.' ,那么此时匹配
        boolean firstMatch = false;
        if(!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0)=='.')){
            firstMatch = true;
        }
        //如果P的长度超过2，并且第二个字符是*，这样的话，这个*有两种情况，1-匹配前面的字符0次，2-匹配前面的字符N次
        if(p.length()>=2 && p.charAt(1) == '*'){
            //matchZeroPreceding 代表P当前的'*' 重复前面的元素0次，那么也就是说当前的*和前面的元素一起消失了。进入下一次递归的是整个S和P[2:]
            boolean matchZeroPreceding = isMatch(s,p.substring(2));
            //matchMorePreceding 代表 p当前的*，重复前面的元素多次.
            //如果第一个字符匹配了，那么剩下的递归中，S只需取剩下的元素[1:],而P则需取当前整个字符。
            //因为P中*此时重复前面元素N次，就是为了与S匹配，所以进入下次递归时仍要带上前面的那个字符，这样才能体现重复多次的情况
            boolean matchMorePreceding = firstMatch && isMatch(s.substring(1),p);
            return matchZeroPreceding || matchMorePreceding;
        }
        //此种情况是p的第二个元素不是'*'，那么比较完第一个元素，就比较后面其他元素。
        else {
            return firstMatch && isMatch(s.substring(1),p.substring(1));
        }
    }

    public static void main(String[] args){
        System.out.print(new Regular_Expression_Matching().isMatch("aaac","a*c"));
    }
}