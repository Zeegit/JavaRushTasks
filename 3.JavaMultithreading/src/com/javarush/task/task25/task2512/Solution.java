package com.javarush.task.task25.task2512;

import java.util.*;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Deque<Throwable> q = new ArrayDeque<>();

        t.interrupt();
        while (e != null){
            q.push(e);
            e = e.getCause();
        }

        while (!q.isEmpty()) {
            System.out.println(q.pop());
        }
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
