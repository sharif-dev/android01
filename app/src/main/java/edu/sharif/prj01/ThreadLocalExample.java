package edu.sharif.prj01;

public class ThreadLocalExample {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    void doWork(){
        threadLocal.set( (int) (Math.random() * 100D) );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    Integer getValue(){
        return threadLocal.get();
    }
}
