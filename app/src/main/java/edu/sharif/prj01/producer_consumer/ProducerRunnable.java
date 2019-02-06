package edu.sharif.prj01.producer_consumer;

/**
 * @Author: MahdiHS
 * @Date: 06/02/2019
 */
public class ProducerRunnable implements Runnable {

    private Buffer buffer;

    public ProducerRunnable(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            buffer.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
