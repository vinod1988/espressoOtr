package org.espressootr.unittest;

import static org.junit.Assert.*;

import org.espressootr.lib.encoding.Encoding;
import org.junit.Test;

public class TestEncoding
{
    
    @Test
    public void test()
    {
        String jvmEncoding = Encoding.getJVMEncoding();
        
        assertEquals(jvmEncoding, "UTF8");
        
    }
    
}
