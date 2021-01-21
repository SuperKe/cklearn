package com.ck2020.cklearn.volatile_demo;

/**
 * @author chenke
 * @create 2020/10/15
 * @Describe
 */
public class VolatileMain {

    private static final int THREADS_COUNT = 10;

    private static volatile int value = 0;

    /**
     * value = 0 是原子操作
     * value++ 不是原子操作
     * 这里同步要加锁synchronized
     */
    private synchronized static void increase() {
        // 对value变量进行自增操作
        value++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        // 每个线程对value变量进行1000次自增操作
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        // 主线程等待子线程运行结束
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("value的值：" + value);
    }
}
