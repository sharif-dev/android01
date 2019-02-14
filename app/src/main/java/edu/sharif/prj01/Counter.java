package edu.sharif.prj01;

public class Counter {
    protected long count = 0;

    public void doWork(){
        for (int i = 0; i<100000;i++){
            this.count = this.count + 1;
        }
    }

    public void safeDoWork(){ // preventing race condition with following two synchronized blocks
        synchronized(this){ // you can put in parenthesis any object that you want to put a lock for the thread (that you want to work lonely) on it until it's work done
            for (int i = 0; i<100000;i++){
                this.count = this.count + 1;
            }
        }

//        for (int i = 0; i<100000;i++){
//            synchronized (this){
//                this.count = this.count + 1;
//            }
//        }
    }
}
