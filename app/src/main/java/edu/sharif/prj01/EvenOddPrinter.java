package edu.sharif.prj01;

import android.util.Log;
import static edu.sharif.prj01.MainActivity.TAG;

public class EvenOddPrinter {
    private volatile boolean isOdd;
//    use volatile to have last version from main memory

    synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        Log.i(TAG, "OddEven, print even ]]>>" +
                        Thread.currentThread().getId() + ":" + number
               );
        isOdd = false;
        notify();
    }
    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        Log.i(TAG, "OddEven, print odd ]]>>" +
                Thread.currentThread().getId() + ":" + number
               );
        isOdd = true;
        notify();
    }
}
