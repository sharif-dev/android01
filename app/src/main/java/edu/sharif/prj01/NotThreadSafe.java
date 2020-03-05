package edu.sharif.prj01;

public class NotThreadSafe{
    static StringBuilder staticBuilder = new StringBuilder();
    StringBuilder builder = new StringBuilder();


    public void add(String text){
        this.builder.append(text);
    }

    public void addToStaticBuilder(String text){
        staticBuilder.append(text);
    }

    public static class MyRunnable implements Runnable{
        NotThreadSafe instance = null;

        public MyRunnable(NotThreadSafe instance){
            this.instance = instance;
        }

        public void run(){
            this.instance.add("some text");
        }
    }

    public static class MyRunnablePrime implements Runnable{
        NotThreadSafe instance = null;

        public MyRunnablePrime(NotThreadSafe instance){
            this.instance = instance;
        }

        public void run(){
            this.instance.addToStaticBuilder("some text");
        }
    }
}