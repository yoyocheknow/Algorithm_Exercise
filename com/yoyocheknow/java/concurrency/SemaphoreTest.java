package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * concurrency.SemaphoreTest
 * Semaphore可以用于做流量控制，特别是公用资源有限的应用场景，比如数据库连接。
 * 假 如有一个需求，要读取几万个文件的数据，因为都是IO密集型任务，我们可以启动
 * 几十个线程 并发地读取，但是如果读到内存后，还需要存储到数据库中，而数据库的
 * 连接数只有10个，这 时我们必须控制只有10个线程同时获取数据库连接保存数据，
 * 否则会报错无法获取数据库连接。
 *
 * 在代码中，虽然有30个线程在执行，但是只允许10个并发执行。Semaphore的构造方法
 * Semaphore(int permits)接受一个整型的数字，表示可用的许可证数量。
 * Semaphore(10)表示允 许10个线程获取许可证，也就是最大并发数是10。
 * Semaphore的用法也很简单，首先线程使用 Semaphore的acquire()方法获取一个许可证，
 * 使用完之后调用release()方法归还许可证。还可以 用tryAcquire()方法尝试获取许可证。
 * @author zhihua on 2021/2/2
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);
    public static void main(String[] args) {
        for (int i = 0; i< THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
               @Override
               public void run() {
                   try {
                       s.acquire();
                       System.out.println(Thread.currentThread().getName()+" save data");
                       //加上一个休眠时间，可以发现线程是10个10个执行的。
                       Thread.sleep(2000);
                       s.release();
                   } catch (InterruptedException e) {
                   }
               }
           });
        }
        threadPool.shutdown();
        }
}