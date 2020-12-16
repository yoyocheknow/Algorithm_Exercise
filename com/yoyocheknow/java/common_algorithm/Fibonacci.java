package common_algorithm;

/**
 * 斐波那契数列
 *
 * @author zhihua on 2020/12/16
 */
public class Fibonacci {
    public int solution1(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return solution1(n-1)+solution1(n-2);
    }

    public int solution2(int n){
       if(n<=0){
           return 0;
       }
        if(n<=2){
            return 1;
        }
        int f1=1;
       int f2 =1;
       int f=0;
        for(int i=3;i<=n;i++){
            f=f1+f2;
            f1=f2;
            f2=f;
        }
        return f;
    }
    public static void main(String[] args){
        System.out.print(new Fibonacci().solution2(5));
    }
}