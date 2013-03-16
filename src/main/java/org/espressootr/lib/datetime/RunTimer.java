package org.espressootr.lib.datetime;

public class RunTimer
{
    private long start = 0;
    
    private long stop = 0;
    
    public void start()
    { 
        start = System.currentTimeMillis();
    }
    
    public void stop()
    {
        stop = System.currentTimeMillis();
    }
    
    public long elaspedMillTime()
    {
        long diff = stop - start;
        return diff;
    }
    
    public long elaspedTime()
    { 
        long diff = stop - start; 
        return diff / 1000; 
    }
    
}
