package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * concurrency.CyclicBarrierTest
 *
 * @author zhihua on 2021/2/2
 */
public class CyclicBarrierTest {
    /**
    * 如果把new CyclicBarrier(2)修改成new CyclicBarrier(3)，则主线程和子线程会永远等待，
     * 因为没有第三个线程执行await方法，即没有第三个线程到达屏障，所以之前到达屏障的两个 线程都不会继续执行。
     *
     * CyclicBarrier可以用于多线程计算数据，最后合并计算结果的场景。例如，用一个Excel保存了用户所有银行流水，
     * 每个Sheet保存一个账户近一年的每笔银行流水，现在需要统计用户 的日均银行流水，先用多线程处理每个sheet里
     * 的银行流水，都执行完之后，得到每个sheet的日 均银行流水，最后，再用barrierAction用这些线程的计算结果，
     * 计算出整个Excel的日均银行流水
     */
    static CyclicBarrier c = new CyclicBarrier(3);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) { }
                System.out.println(1);
            } }).start();

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}