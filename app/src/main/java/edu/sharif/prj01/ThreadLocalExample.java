package edu.sharif.prj01;

public class ThreadLocalExample {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    void doWork() {
        threadLocal.set((int) (Math.random() * 100D)); // this will not work and will be skipped (ThreadLocal property), you should override initialValue method to initial a ThreadLocal
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    Integer getValue() {
        return threadLocal.get();
    }
}
