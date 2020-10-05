package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;
    private Thread.State state;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;

    }

    @Override
    public void run() {
        while (true) {
            Thread.State s = thread.getState();
            if (s != state) {
                System.out.println(thread.getState());
                state = s;
            }
            if (state == State.TERMINATED) {
                break;
            }
        }
    }
}
