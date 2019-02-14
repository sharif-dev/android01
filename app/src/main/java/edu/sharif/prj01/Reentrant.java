package edu.sharif.prj01;

import android.util.Log;

public class Reentrant{

    public synchronized void outer(){
        Log.i(MainActivity.TAG, "outer");
        inner(); // this is the where Reenetrant happens, when invoker thread held lock on this object and also acquire another lock when invoking this inner synchronized method
    }

    public synchronized void inner(){
        Log.i(MainActivity.TAG, "inner");
        //do something
    }
}
