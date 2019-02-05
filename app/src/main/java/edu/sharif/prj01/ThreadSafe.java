package edu.sharif.prj01;

import android.util.Log;

public class ThreadSafe {

    public void LocalVariables(){
        long threadSafeInt = 0;
        threadSafeInt++;
    }

    // If an object created locally never escapes the method it was created in, it is thread safe.
    // In fact you can also pass it on to other methods and objects as long as none of these methods
    // or objects make the passed object available to other threads.

    // The LocalObject instance in this example is not returned from the method, nor is it passed
    // to any other objects that are accessible from outside the someMethod() method.
    // Each thread executing the someMethod() method will create its own LocalObject instance and
    // assign it to the localObject reference. Therefore the use of the LocalObject here is thread safe.
    //
    // In fact, the whole method someMethod() is thread safe. Even if the LocalObject instance is
    // passed as parameter to other methods in the same class, or in other classes,
    // the use of it is thread safe.
    //
    // The only exception is of course, if one of the methods called with the LocalObject as
    // parameter, stores the LocalObject instance in a way that allows access to it from other threads.
    public void LocalObjectReferences(){
        LocalObject localObject = new LocalObject();
        method2(localObject);
        Log.i(MainActivity.TAG, "val:" + localObject.getVal());
    }

    public void method2(LocalObject val){
        val.setVal(200);
    }

    static class LocalObject{
        int val;

        void setVal(int v){
            val = v;
        }

        int getVal(){
            return val;
        }
    }
}
