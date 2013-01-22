package org.espressootr.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.espressootr.lib.collection.cs.Canister;
import org.espressootr.lib.collection.cs.Shelfer;
import org.espressootr.lib.file.FileReaderManager;
import org.espressootr.lib.sort.QuickSort;
import org.junit.Before;
import org.junit.Test;

public class UT_Canister
{
    
    Canister canitser = null;
    
    @Before
    public void setUp() throws Exception
    {
        List<String> testCanister = new ArrayList<String>();
        testCanister.add("1231323");
        testCanister.add("1sdfs");
        testCanister.add("1223a2331323");
        testCanister.add("1231fsdfsf323");
        canitser = new Canister("1", testCanister, false);
        
    }
    
    @Test
    public void test_toHashMap() throws IOException
    {
        
        HashMap<String, List<String>> csMap = canitser.toHashMap();
        
        org.junit.Assert.assertEquals(1, csMap.size());
        //System.out.println(csMap);
    }
    
    @Test
    public void test_toJson() throws IOException
    {
        System.out.println(canitser.toJson());
        
        
    }
}