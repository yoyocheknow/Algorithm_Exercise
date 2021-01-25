package common_algorithm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者问题
 *
 * @author zhihua on 2021/1/25
 */
public class Producer_Consumer {

    /**
     * wait() notify() 实现
     */
    private static Integer count = 0;
    private static final Integer FULL =10;
    private static String LOCK = "lock";
    class Producer1 implements Runnable {
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while(count == FULL){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产，目前总共有"+count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer1 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while(count == 0){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消费，目前总共有"+count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    /**
     * Condition + ReentrantLock实现
     */
    private Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    class Producer2 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();
                while (count==FULL){
                    try {
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(Thread.currentThread().getName()+"生产，目前总共有"+count);
                notEmpty.signal();
                lock.unlock();
            }
        }
    }
    class Consumer2 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();
                while (count==0){
                    try {
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(Thread.currentThread().getName()
                        + "消费者消费，目前总共有" + count);
                notFull.signal();
                lock.unlock();
            }
        }
    }
    /**
     * 阻塞队列实现
     */
    //创建一个阻塞队列
    final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);
    class Producer3 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    blockingQueue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println(Thread.currentThread().getName()+"生产，目前总共有"+count);
            }
        }
    }
    class Consumer3 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println(Thread.currentThread().getName()
                        + "消费者消费，目前总共有" + count);

            }
        }
    }

    /**
     * semaphore实现
     */
    //创建三个信号量
    final Semaphore notFullSema = new Semaphore(10);
    final Semaphore notEmptySema = new Semaphore(0);
    final Semaphore mutex = new Semaphore(1);

    class Producer4 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    notFullSema.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产，目前总共有"+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    mutex.release();
                    notEmptySema.release();
                }

            }
        }
    }
    class Consumer4 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    notEmptySema.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    mutex.release();
                    notFullSema.release();
                }


            }
        }
    }
    public static void main(String[] args) {
        Producer_Consumer test1 = new Producer_Consumer();
        new Thread(test1.new Producer4()).start();
        new Thread(test1.new Consumer4()).start();

    }

}