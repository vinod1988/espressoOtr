package org.espressootr.unittest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.espressootr.lib.collection.cs.map.MapShelfer;
import org.junit.Before;
import org.junit.Test;

public class TestMapShelfer
{
    
    @Before
    public void setUp() throws Exception
    {
        
    }
    
    @Test
    public void testAsh841Bug() throws IOException
    {
        MapShelfer mapShelfer = new MapShelfer();
        mapShelfer.add("test", 1111133);
        mapShelfer.add("test4", 1111132);
        
        mapShelfer.add("ash84", 111113);
        mapShelfer.add("ash841", 111141);
        mapShelfer.add("ash842", 111141);
        
        assertEquals(mapShelfer.size(), 2);
        
    }
    
}
