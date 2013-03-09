package org.espressootr.unittest.cs;

import static org.junit.Assert.*;

import org.espressootr.lib.collection.cs.list.ListShelfer; 
import org.junit.Before; 
import org.junit.Test;

public class TestListShelfer
{
    
    ListShelfer listShelfer = new ListShelfer();
    
    @Before
    public void setUp() throws Exception
    {
        listShelfer.add("apple");
        listShelfer.add("bob");
        listShelfer.add("boss");
        listShelfer.add("starbucks");
        listShelfer.add("java");
        listShelfer.add("steve");
        listShelfer.add("json");
    }
    
    
    @Test
    public void test()
    {
        System.out.println(listShelfer.search("bob"));
        
        
    }
}
