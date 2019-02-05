package edu.sharif.prj01;

import android.util.Log;

public class MyRunnable implements Runnable {

    public void run(){
        Log.i(MainActivity.TAG, "MyRunnable ]]>> " +
                " pid: " + android.os.Process.myPid()+
                " tid: " + android.os.Process.myTid()+
                " id: " + Thread.currentThread().getId());
    }
}