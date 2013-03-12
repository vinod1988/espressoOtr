package org.espressootr.unittest;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.espressootr.lib.collection.MapUtil;
import org.junit.Before;
import org.junit.Test;

public class TestMapUtil
{
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    @Before
    public void setUp() throws Exception
    {
        map.put("ash84", 30);
        map.put("ash841", 301);
        map.put("ash842", 302);
        map.put("ash843", 303);
        
        
    }
    
    @Test
    public void testGetValueList()
    {
        assertEquals(MapUtil.getValueList(map).size(), 4);
    }
    
}
