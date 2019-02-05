package edu.sharif.prj01;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

public class Notifier implements Runnable {

    private Message msg;
    final CountDownLatch latch;

    public Notifier(Message msg, CountDownLatch latch) {
        this.msg = msg;
        this.latch = latch;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        Log.i(MainActivity.TAG, "WaitNotifyTest.Notifier]>> started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(name+" Notifier work done");
                msg.notify();
                // msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.latch.countDown();
    }
}