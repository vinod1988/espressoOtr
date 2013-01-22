package org.espressootr.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.espressootr.lib.collection.cs.Shelfer;
import org.espressootr.lib.file.FileReaderManager;
import org.espressootr.lib.sort.QuickSort;
import org.junit.Before;
import org.junit.Test;


public class UT_CanisterShelfer
{
    
    List<String> testSet = null; 
    
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
        Shelfer testShelf = new Shelfer(testSet);
        
        System.out.println(testShelf.toString());
         

    }
    
}
