import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * java SE Test
 *
 * @author zhihua on 2020/12/28
 */
public class TestJava {

    public int findMax(String s,int max){
        if(s.length()==1){
            return 1;
        }

        for(int i=0;i<s.length()-1;i++){
            max = isHuiwen(s,i,i,max);
            max = isHuiwen(s,i,i+1,max);
        }
        return max;

    }

    public int isHuiwen(String s,int low,int high,int max){
        while(low>=0 && high<s.length()){
            if(s.charAt(low)==s.charAt(high)){
                if(high-low+1>max){
                    max = high-low+1;
                }
                low--;
                high++;
            }else{
                return max;
            }
        }
        return max;
    }
    public static void main(String[] args){

       System.out.println(new TestJava().findMax("qsaasiaadaa",0));
        //System.out.println(new TestJava().findMax("qqqq"));
    }
}