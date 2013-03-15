package org.espressootr.unittest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.math.MinMaxUtil;
import org.junit.Before;
import org.junit.Test;

public class TestMath
{
    
    int intArr[] = new int[10];
    
    List<Integer> intList = new ArrayList<Integer>();
    
    @Before
    public void setUp() throws Exception
    {
        for (int i = 0; i < 10; i++)
        {
            intArr[i] = i;
            intList.add(i);
        }
    }
    
    @Test
    public void testMaxValue()
    {
       assertEquals(9, MinMaxUtil.getMaxValue(intArr));
       assertEquals(9, MinMaxUtil.getMaxValue(intList));
       
       
    }
}
