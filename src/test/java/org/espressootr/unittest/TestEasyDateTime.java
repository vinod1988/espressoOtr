package org.espressootr.unittest;

import static org.junit.Assert.*;

import org.espressootr.lib.datetime.EasyDateTime;
import org.junit.Test;

public class TestEasyDateTime
{
    
    @Test
    public void tesGetNow()
    {
        System.out.println(EasyDateTime.getNow());
        
    }
    
    @Test
    public void tesGetNowString()
    {
        System.out.println(EasyDateTime.getNowString());
        
    }
    
    
}
