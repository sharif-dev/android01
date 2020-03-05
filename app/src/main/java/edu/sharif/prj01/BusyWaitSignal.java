package edu.sharif.prj01;

public class BusyWaitSignal {
    protected boolean hasDataToProcess = true;


    public synchronized boolean hasDataToProcess(){
        return this.hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasData){
        this.hasDataToProcess = hasData;
    }

}
