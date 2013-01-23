package org.espressootr.test;

import static org.junit.Assert.*;

import org.espressootr.lib.text.jaso.JasoAssembler;
import org.junit.Before;
import org.junit.Test;

public class UT_JasoAssembler
{
    
    JasoAssembler jasoAssem = null;
    
    @Before
    public void setUp() throws Exception
    {
        jasoAssem = new JasoAssembler();
    }
    
    @Test
    public void test()
    {
        String letter = "ㅇㅏㄴㅅㅓㅇㅎㅕㄴ";
        
        assertEquals("안성현", jasoAssem.assemblyJaso(letter));
        
    }
    
}
