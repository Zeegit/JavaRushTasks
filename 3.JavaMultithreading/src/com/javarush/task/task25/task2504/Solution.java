package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        /*1. Если нить еще не запущена, то запусти ее.
        2. Если нить в ожидании, то прерви ее.
        3. Если нить работает, то проверь маркер isInterrupted.
        4. Если нить прекратила работу, то выведи в консоль ее приоритет.*/
        for (Thread thead : threads) {
            switch (thead.getState()) {
                case NEW:
                    thead.start();
                    break;
                case WAITING:
                case TIMED_WAITING:
                case BLOCKED:
                    thead.interrupt();
                    break;
                case RUNNABLE:
                    if (thead.isInterrupted()) {

                    }
                    break;
                case TERMINATED:
                    System.out.println(thead.getPriority());
                    break;

            }
        }
    }

    public static void main(String[] args) {
    }
}
