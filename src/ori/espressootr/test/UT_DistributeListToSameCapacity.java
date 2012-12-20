package ori.espressootr.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.espressootr.lib.collection.ListDistributor;
import org.junit.Before;
import org.junit.Test;

public class UT_DistributeListToSameCapacity
{
    List<String> target = new ArrayList<String>();
    
    @Before
    public void setUp() throws Exception
    {
        for (int i = 0; i < 10; i++)
        {
            target.add(String.valueOf(i));
        }
    }
    
    @Test
    public void test_REGULAR_DISTRIBUTE()
    {
        
        int distributionFactor = 3;
        HashMap<Integer, List<String>> dist = ListDistributor.distributeListToSameCapacity(distributionFactor, target);
        
        assertEquals(4, dist.size());
        
        for (int i = 0; i < dist.size(); i++)
        {
            assertEquals(validSize(dist.get(i).size(), distributionFactor), true);
        }
        
    }
    
    @Test
    public void test_ZERO_DISTRIBUTE()
    {
        
        int distributionFactor = 0;
        HashMap<Integer, List<String>> dist = ListDistributor.distributeListToSameCapacity(distributionFactor, target);
        
        assertEquals(1, dist.size());
        
        for (int i = 0; i < dist.size(); i++)
        {
            assertEquals(validSize(dist.get(i).size(), 10), true);
        }
        
    }
    
    @Test
    public void test_ONE_DISTRIBUTE()
    {
        int distributionFactor = 1;
        HashMap<Integer, List<String>> dist = ListDistributor.distributeListToSameCapacity(distributionFactor, target);
        
        assertEquals(10, dist.size());
        
        for (int i = 0; i < dist.size(); i++)
        {
            assertEquals(validSize(dist.get(i).size(), distributionFactor), true);
        }
    }
    
    @Test
    public void test_EXCEED_DISTRIBUTE()
    {
        int distributionFactor = 20;
        HashMap<Integer, List<String>> dist = ListDistributor.distributeListToSameCapacity(distributionFactor, target);
        
        assertEquals(1, dist.size());
        
        for (int i = 0; i < dist.size(); i++)
        {
            assertEquals(validSize(dist.get(i).size(), distributionFactor), true);
        }
        
    }
    
    @Test
    public void test_MINUS_FACTOR_DISTRIBUTE()
    {
        int distributionFactor = -1;
        HashMap<Integer, List<String>> dist = ListDistributor.distributeListToSameCapacity(distributionFactor, target);
        
        assertEquals(1, dist.size());
        
        for (int i = 0; i < dist.size(); i++)
        {
            assertEquals(validSize(dist.get(i).size(), 10), true);
        }
    }
    
    @Test
    public void test_IS_REMOVE_ORIGINAL()
    {
        int distributionFactor = 3;
        HashMap<Integer, List<String>> dist = ListDistributor.distributeListToSameCapacity(distributionFactor, target);
        
        for (int i = 0; i < dist.size(); i++)
        {
            dist.get(i).remove(0);
        }
        
        assertEquals(10, target.size());
    }
    
    private boolean validSize(int size, int factor)
    {
        boolean isValid = true;
        
        if (size > factor)
        {
            isValid = false;
        }
        
        return isValid;
    }
    
}
