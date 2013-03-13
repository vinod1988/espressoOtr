package org.espressootr.unittest;

import static org.junit.Assert.*;

import org.espressootr.lib.encoding.Unicode;
import org.junit.Test;

public class TestUnicode
{
    
    @Test
    public void test()
    {
        String unicode = "";
        
        unicode = Unicode.getUnicodeFromString("ash84", 0);
        assertEquals(unicode, "0X0061");
        
        unicode = Unicode.getUnicodeFromString("ash84", 1);
        assertEquals(unicode, "0X0073");
        
        unicode = Unicode.getUnicodeFromString("ash84", 2);
        assertEquals(unicode, "0X0068");
        
        unicode = Unicode.getUnicodeFromString("ash84", 3);
        assertEquals(unicode, "0X0038");
        
        unicode = Unicode.getUnicodeFromString("ash84", 4);
        assertEquals(unicode, "0X0034");
        
        
        
        
    }
    
}
