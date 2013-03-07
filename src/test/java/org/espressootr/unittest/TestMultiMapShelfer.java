package org.espressootr.unittest;

import static org.junit.Assert.*;

import java.util.List;

import org.espressootr.lib.collection.cs.multmap.MultiMapShelfer;
import org.junit.Before;
import org.junit.Test;

public class TestMultiMapShelfer
{
    MultiMapShelfer mmShelfer = new MultiMapShelfer();
    
    @Before
    public void setUp() throws Exception
    {
        
        mmShelfer.add("ash84", 1111);
        mmShelfer.add("ash84", 1111);
        mmShelfer.add("ash84", 1111);
        mmShelfer.add("ash8", 1113);
        mmShelfer.add("ash4", 1112);
        
        System.out.println(mmShelfer.toString());
    }
    
    @Test
    public void testBasicCategorizing()
    {
        assertEquals(mmShelfer.get("a").getbeans().size(), 3);
        assertEquals(mmShelfer.get("a").getbeans().get("ash84").size(), 3);
    }
    
    @SuppressWarnings("rawtypes")
    @Test
    public void testSearch()
    {
        List mmSearchedValue = (List) mmShelfer.search("ash84");
        
        assertEquals(mmSearchedValue.size(), 3);
        
    }
    
}
