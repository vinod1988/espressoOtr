package org.espressootr.unittest.cs;

import static org.junit.Assert.*;

import java.util.List;

import org.espressootr.lib.collection.cs.multmap.MultiMapCanister;
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
        
        //System.out.println(mmShelfer.toString());
    }
    
    @Test
    public void testBasicCategorizing()
    {
        assertEquals(mmShelfer.get("a").getBeans().size(), 3);
        assertEquals(mmShelfer.get("a").getBeans().get("ash84").size(), 3);
    }
    
    @SuppressWarnings("rawtypes")
    @Test
    public void testSearch()
    {
        List mmSearchedValue = (List) mmShelfer.search("ash84");
        
        assertEquals(mmSearchedValue.size(), 3);
        
    }
    
    @Test
    public void testRearrange()
    {
        
    }
    
    @Test
    public void testGetTags()
    {
        List<String> tags = mmShelfer.getTags();
        assertEquals(tags.size(), 1);
        
        mmShelfer.add("ttt", 1839);
        tags = mmShelfer.getTags();
        assertEquals(tags.size(), 2);
        
    }
    
    @Test
    public void testSize()
    {
        assertEquals(mmShelfer.size(), 1);
    }
    
    @Test
    public void testClear()
    {
        mmShelfer.clear();
        assertEquals(mmShelfer.size(), 0);
    }
    
    @Test
    public void testAddMultiMapCanister() throws Exception
    {
        
        //No duplication canister => shelf.size()+1; 
        MultiMapCanister mmCanIu = new MultiMapCanister("i", "iu", "chirstmas");
        mmShelfer.add(mmCanIu);
        assertEquals(mmShelfer.size(), 2);
        
        
        //duplication canister => shelf.size()+1;
        MultiMapCanister mmCanAs = new MultiMapCanister("a", "au", "chirstmas");
        mmShelfer.add(mmCanAs);
 
        
        assertEquals(mmShelfer.size(), 2);
        
    }
    
}
