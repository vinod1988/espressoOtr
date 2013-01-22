package org.espressootr.test;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import org.espressootr.lib.collection.cs.Canister;
import org.espressootr.lib.collection.cs.Shelfer;
import org.espressootr.lib.file.FileReaderManager;
import org.espressootr.lib.sort.QuickSort;
import org.junit.Before;
import org.junit.Test;

public class UT_Shelfer
{
    
    List<String> testSet = null;
    Shelfer testShelf = null;
    
    @Before
    public void setUp() throws Exception
    {
        String filePath = "./resources/test/cs-test.txt";
        testSet = FileReaderManager.readLineFromFile(filePath);
        QuickSort.sort(testSet);
    }
    
    @Test
    public void test_CreateShelf() throws IOException
    {
        testShelf = new Shelfer(testSet);
        org.junit.Assert.assertEquals(138, testShelf.size());
    }
    
    @Test
    public void test_toHashMap() throws IOException
    {
        test_CreateShelf();
        
        HashMap<String, Canister> csMap = testShelf.toHashMap();
        
        org.junit.Assert.assertEquals(138, csMap.size());
    }
    
    @Test
    public void test_remove_tag() throws IOException
    {
        test_CreateShelf();
        
        this.testShelf.remove("꿈");
        
        // System.out.println(this.testShelf.toString());
        org.junit.Assert.assertEquals(137, testShelf.size());
        
    }
    
    @Test
    public void test_toJson() throws IOException
    {
        test_CreateShelf();
        
        //System.out.println(this.testShelf.toJson());
        
    }
    
}
