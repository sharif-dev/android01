package edu.sharif.prj01;

import android.util.Log;

public class Reentrant{

    public synchronized void outer(){
        Log.i(MainActivity.TAG, "outer");
        inner();
    }

    public synchronized void inner(){
        Log.i(MainActivity.TAG, "inner");
        //do something
    }
}
