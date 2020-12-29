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
        HashMap map = new HashMap(4);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(5,5);
        map.put(6,6);

        LinkedHashMap linkedHashMap = new LinkedHashMap<>();
        CompletableFuture.supplyAsync(()->{
            System.out.print("new thread");
            return "11";});

    }
}