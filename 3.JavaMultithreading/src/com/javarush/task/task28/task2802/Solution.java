package com.javarush.task.task28.task2802;

import java.util.PriorityQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {
    public static AtomicInteger a = new AtomicInteger(0);


    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        AtomicInteger b = new AtomicInteger(0);
        int fac;

        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName(String.format("%s-pool-%d-thread-%d", Thread.currentThread().getThreadGroup().getName(), fac, b.incrementAndGet()));
            t.setPriority(Thread.NORM_PRIORITY);
            t.setDaemon(false);
            return t;
        }

        public AmigoThreadFactory() {
            fac = a.incrementAndGet();
        }
    }
}
