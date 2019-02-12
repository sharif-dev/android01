package edu.sharif.prj01;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

public class Waiter implements Runnable {

    private Message msg;
    private final CountDownLatch latch;

    public Waiter(Message m, CountDownLatch latch) {
        this.msg = m;
        this.latch = latch;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                Log.i(MainActivity.TAG, "WaitNotifyTest.Waiter]>> time:"
                        + System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //process the message now
            Log.i(MainActivity.TAG, "WaitNotifyTest.Waiter]>> name:"
                    + name + " processed:" + msg.getMsg());
            this.latch.countDown();
        }
    }
}