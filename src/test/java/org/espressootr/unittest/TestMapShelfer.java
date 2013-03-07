package org.espressootr.unittest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.espressootr.lib.collection.cs.map.MapShelfer;
import org.junit.Before;
import org.junit.Test;

public class TestMapShelfer
{
    MapShelfer mapShelfer = new MapShelfer();
    
    @Before
    public void setUp() throws Exception
    { 
        mapShelfer.add("test", 1111133);
        mapShelfer.add("test4", 1111132); 
        mapShelfer.add("ash84", "111113");
        mapShelfer.add("ash841", 111141);
        mapShelfer.add("ash842", 111141);
        
        System.out.println(mapShelfer.toString());
    }
    
    @Test
    public void testAsh841Bug() throws IOException
    { 
        assertEquals(mapShelfer.size(), 2); 
    }
    
    @Test
    public void testBasicCategorizing()
    {
        assertEquals(mapShelfer.get("a").getbeans().size(), 3); 
    }
     
    @Test
    public void testSearch()
    {
        String mapSearchedValue = (String) mapShelfer.search("ash84");
        
        assertEquals(mapSearchedValue, "111113");
        
    }
    
}
