import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger(交换者)是一个用于线程间协作的工具类。Exchanger用于进行线程间的数据交换。
 * 它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。这两个线程通过 exchange
 * 方法交换数据，如果第一个线程先执行exchange()方法，它会一直等待第二个线程也 执行
 * exchange方法，当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的
 * 数据传递给对方。
 * @author zhihua on 2021/2/2
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";    // A录入银行流水数据
                    exgr.exchange(A);

                } catch (InterruptedException e) { }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";    // B录入银行流水数据
                    String A = exgr.exchange(B);
                    Thread.sleep(2000);
                    System.out.println("A和B数据是否一致:" + A.equals(B) + "，A录入的是:" + A + "，B录入是:" + B);
                }catch (Exception e){}
                }
        });
        threadPool.shutdown();
    }
}