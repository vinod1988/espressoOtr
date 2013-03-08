package org.espressootr.unittest.cs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        
        // System.out.println(mmShelfer.toString());
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
        // No duplication canister => shelf.size()+1;
        MultiMapCanister mmCanIu = new MultiMapCanister("i", "iu", "chirstmas");
        mmShelfer.add(mmCanIu);
        assertEquals(mmShelfer.size(), 2);
        
        // duplication canister => shelf.size()+1;
        MultiMapCanister mmCanAs = new MultiMapCanister("a", "au", "chirstmas");
        mmShelfer.add(mmCanAs);
        
        assertEquals(mmShelfer.size(), 2);
    }
    
    @Test
    public void testRemove()
    {
        
        mmShelfer.remove(0);
        
        assertEquals(mmShelfer.size(), 0);
        
    }
    
    @Test
    public void testRemoveTag()
    { 
        mmShelfer.remove("a"); 
        assertEquals(mmShelfer.size(), 0);
    }
    
    @Test
    public void testGetShelf()
    {
        List<MultiMapCanister> shelf = mmShelfer.getShelf();
        
        assertEquals(shelf.size(), 1);
        
    }
    
    @Test
    public void testGet()
    {
        MultiMapCanister mmCan = mmShelfer.get("ash84");
     
        assertEquals(mmCan.getTag(), "a");
        assertEquals(mmCan.getBeans().size(), 3); 
    }
    
    @Test
    public void testToHashMap()
    {
        HashMap<String, MultiMapCanister> shelferMap = mmShelfer.toHashMap();
        assertEquals(shelferMap.get("a").getBeans().size(), 3); 
    }
    
    @SuppressWarnings("rawtypes")
    @Test
    public void testMultiMapShelferAllSameTagCase()
    {
        Map<String, List> willAddBeans = new HashMap<String, List>();
       
        List beanValue1 = new ArrayList();
        beanValue1.add(1111);
        beanValue1.add(1112);
        beanValue1.add(1113);
        beanValue1.add(11141);
        willAddBeans.put("tt", beanValue1);
        
        List beanValue2 = new ArrayList();
        beanValue2.add(1111);
        beanValue2.add(1112);
        beanValue2.add(1113);
        beanValue2.add(11141);
        willAddBeans.put("t1", beanValue2);
        
        
        
        List beanValue3 = new ArrayList();
        beanValue3.add(1111);
        beanValue3.add(1112);
        beanValue3.add(1113);
        beanValue3.add(11141);
        willAddBeans.put("t3", beanValue3);
        
        
        MultiMapShelfer tmpMmShelfer = new MultiMapShelfer(willAddBeans);
        assertEquals(tmpMmShelfer.getTags().size(), 1);
        
    }
    
    @SuppressWarnings("rawtypes")
    @Test
    public void testMultiMapShelferAllDiffTagCase()
    {
        Map<String, List> willAddBeans = new HashMap<String, List>();
       
        List beanValue1 = new ArrayList();
        beanValue1.add(1111);
        beanValue1.add(1112);
        beanValue1.add(1113);
        beanValue1.add(11141);
        willAddBeans.put("ta", beanValue1);
        
        List beanValue2 = new ArrayList();
        beanValue2.add(1111);
        beanValue2.add(1112);
        beanValue2.add(1113);
        beanValue2.add(11141);
        willAddBeans.put("t1", beanValue2);
        
        
        
        List beanValue3 = new ArrayList();
        beanValue3.add(1111);
        beanValue3.add(1112);
        beanValue3.add(1113);
        beanValue3.add(11141);
        willAddBeans.put("b3", beanValue3);
        
        
        MultiMapShelfer tmpMmShelfer = new MultiMapShelfer(willAddBeans);
        assertEquals(tmpMmShelfer.getTags().size(), 2);
         
        
    }
    
   
}
