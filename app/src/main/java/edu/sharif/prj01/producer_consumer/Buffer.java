package edu.sharif.prj01.producer_consumer;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;

import edu.sharif.prj01.MainActivity;

/**
 * @Author: MahdiHS
 * @Date: 06/02/2019
 */
public class Buffer {
    public static final int DEFAULT_BUFFER_SIZE = 3;
    private static final int PRODUCER_DELAY_TIME = 2 * 1000;
    private static final int CONSUMER_DELAY_TIME = 2 * 1000;

    private Queue<Product> list = new LinkedList<>();
    private int size;

    public Buffer(int size) {
        this.size = size;
    }

    void produce() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() >= size) wait();
                Product product = Product.create();
                list.add(product);
                Log.i(MainActivity.TAG, "ProducerConsumerExample ]]>> produce: " + product.toString());
                notify();
                Thread.sleep(PRODUCER_DELAY_TIME);
            }
        }
    }

    void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0) wait();
                Product product = list.poll();
                Log.i(MainActivity.TAG, "ProducerConsumerExample ]]>> consume: " + product.toString());
                notify();
                Thread.sleep(CONSUMER_DELAY_TIME);
            }
        }
    }
}
