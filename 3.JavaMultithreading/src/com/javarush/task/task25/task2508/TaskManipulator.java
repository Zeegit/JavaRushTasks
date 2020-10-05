package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private String threadName;
    private Thread thread;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);

            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    @Override
    public void start(String threadName) {
        TaskManipulator taskManipulator = new TaskManipulator();
        thread = new Thread(this, threadName);
        // thread.setName(threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
