package com.javarush.task.task27.task2709;

public class ConsumerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;

    public ConsumerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ConsumerTask").start();
    }

    public void run() {
        synchronized (transferObject) {
            while (!stopped) {
                try {
                    while (!transferObject.isValuePresent) {
                        transferObject.wait();
                    }
                    transferObject.get();
                    transferObject.isValuePresent = false;
                    transferObject.notifyAll();
                } catch (InterruptedException e) {

                }

            }
        }
    }

    public void stop() {
        stopped = true;
    }
}