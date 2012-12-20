package ori.espressootr.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.espressootr.lib.collection.ListDistributor;
import org.junit.Before;
import org.junit.Test;

public class UT_DistributeToSubList
{
    
    @SuppressWarnings("rawtypes")
    List target = new ArrayList();
    
    @SuppressWarnings("unchecked")
    @Before
    public void setUp() throws Exception
    {
        for (int i = 0; i < 10; i++)
        {
            target.add(String.valueOf(i));
        }
    }
    
    @SuppressWarnings("rawtypes")
    @Test
    public void test_REGULAR()
    {
        HashMap<Integer, List> dist = ListDistributor.distributeListToSubList(4, target);
        
        assertEquals(4, dist.size());
        
        for (int i = 0; i < dist.size(); i++)
        {
            List subList = dist.get(i);
            
            for (int j = 0; j < subList.size(); j++)
                System.out.println(String.valueOf(subList.get(j)));
        }
        
    }
    
    @SuppressWarnings("rawtypes")
    @Test
    public void test_ZERO()
    {
        HashMap<Integer, List> dist = ListDistributor.distributeListToSubList(0, target);
        
        assertEquals(1, dist.size());
        
        for (int i = 0; i < dist.size(); i++)
        {
            List subList = dist.get(i);
            
            for (int j = 0; j < subList.size(); j++)
                System.out.println(String.valueOf(subList.get(j)));
        }
        
    }
    
    @SuppressWarnings("rawtypes")
    @Test
    public void test_ONE()
    {
        HashMap<Integer, List> dist = ListDistributor.distributeListToSubList(1, target);
        
        assertEquals(1, dist.size());
        
        for (int i = 0; i < dist.size(); i++)
        {
            List subList = dist.get(i);
            
            for (int j = 0; j < subList.size(); j++)
                System.out.println(String.valueOf(subList.get(j)));
        }
        
    }
    
}
