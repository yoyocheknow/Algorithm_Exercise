package leetcode.String;

/**
 * 二进制加法
 *
 * @author zhihua on 2021/1/8
 */
public class Add_Binary {
    public String addBinary(String a, String b) {
        int la = a.length()-1;
        int lb = b.length()-1;
        int carry =0;
        StringBuilder result = new StringBuilder();
        while (la>=0 && lb>=0){
            int ia = a.charAt(la)-48;
            int ib = b.charAt(lb)-48;
            int sum = ia+ib+carry;
            carry=0;
            if(sum<2){
                result.append(sum);
            }else if(sum==2){
                carry++;
                result.append(0);
            }else if(sum==3){
                result.append(1);
                carry++;
            }
            la--;
            lb--;
        }
        while (la>=0){
            int ia = a.charAt(la)-48;
            int sum = ia+carry;
            carry=0;
            if(sum<2){
                result.append(sum);
            }else if(sum==2){
                result.append(0);
                carry++;
            }else if(sum==3){
                result.append(1);
                carry++;
            }
            la--;
        }
        while(lb>=0){
            int ib = b.charAt(lb)-48;
            int sum = ib+carry;
            carry=0;
            if(sum<2){
                result.append(sum);
            }else if(sum==2){
                result.append(0);
                carry++;
            }else if(sum==3){
                result.append(1);
                carry++;
            }
            lb--;
        }
        if(carry>0){
            result.append(carry);
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(new Add_Binary().addBinary("1010","1011"));
    }
}