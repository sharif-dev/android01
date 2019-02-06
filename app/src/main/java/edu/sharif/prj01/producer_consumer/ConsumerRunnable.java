package edu.sharif.prj01.producer_consumer;

/**
 * @Author: MahdiHS
 * @Date: 06/02/2019
 */
public class ConsumerRunnable implements Runnable {

    private Buffer buffer;

    public ConsumerRunnable(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            buffer.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
