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

        ConcurrentHashMap concurrentHashMap =new ConcurrentHashMap<>();
        concurrentHashMap.put(null,new Object());
        System.out.println(concurrentHashMap.containsKey(null));
    }
}