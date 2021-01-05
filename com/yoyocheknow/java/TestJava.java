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
    public static void main(String[] args){

        Integer a = new Integer(5);
        Integer b = new Integer(5);
        System.out.println(a==b);
        Integer i = 200;
        Integer j = 200;
        System.out.print(i == j);
    }
}