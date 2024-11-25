package com.example.safe.repeaters;


public class Repeater implements IRepeater{
    String exceptionName;
    int counter;
    int retryCount;
    long delayTime;
    private final IRepeaterExceptionRegistry exceptionRegistry;

    public Repeater(IRepeaterExceptionRegistry exceptionRegistry) {
        this.exceptionRegistry = exceptionRegistry;
    }

    @Override
    public IRepeater For(Throwable exception) {
        /*
            Tutaj Twoim zadaniem jest napisanie odpowiedniego algorytmu
         */

        if(exceptionName==null || !exceptionName.equals(exception.getClass().getName())){
            exceptionName = exception.getClass().getName();
            counter = 0;
            retryCount = exceptionRegistry.EntryFor(exception).retriesCount();
            delayTime = exceptionRegistry.EntryFor(exception).delay();
        }
        
        return this;
    }

    @Override
    public void retry() {
        counter++;
    }

    @Override
    public boolean shouldRetry() {
        return counter<=retryCount;
    }

    @Override
    public IRepeater waiting() {
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
