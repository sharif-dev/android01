package edu.sharif.prj01;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class T extends Thread {
    public Handler handler;

    public Looper myLooper() {
        return Looper.myLooper();
    }

    @Override
    public void run() {
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Log.d("T", "Message Handled");
            }
        };
        synchronized (this) {
            notify();
        }
        Looper.loop();
    }
}

