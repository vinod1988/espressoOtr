package org.espressootr.unittest;

import static org.junit.Assert.*;

import org.espressootr.lib.datetime.RunTimer;
import org.junit.Test;

public class TestRunTimer
{
    
    RunTimer rt = new RunTimer();
    
    @Test
    public void test() throws InterruptedException
    
    {
        
        rt.start();
        
        for (int i = 0; i < 10; i++)
        
        {
            
            Thread.sleep(1000);
            
        }
        
        rt.stop();
        
        System.out.println(rt.elaspedMillTime());
        
        System.out.println(rt.elaspedTime());
        
    }
    
}
