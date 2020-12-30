import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;

/**
 * java SE Test
 *
 * @author zhihua on 2020/12/28
 */
public class TestJava {
    public static void main(String[] args){

        String s3 = new String("12")+new String("34");
        s3.intern();
        String s4 = "1234";
        System.out.println(s3 == s4);//true

    }
}