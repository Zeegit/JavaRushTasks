package com.javarush.task.task25.task2514;

/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {

            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
            //Thread.yield();
        }
    }

    public static void main(String[] args) {
        new Thread(new YieldRunnable(10)).start();
        new Thread(new YieldRunnable(20)).start();
        new Thread(new YieldRunnable(30)).start();
        new Thread(new YieldRunnable(40)).start();
    }
}
