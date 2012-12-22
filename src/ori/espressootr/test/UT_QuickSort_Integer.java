package ori.espressootr.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.sort.QuickSort;
import org.junit.Before;
import org.junit.Test;

public class UT_QuickSort_Integer
{
    
    List<Integer> target = new ArrayList<Integer>();
    
    @Before
    public void setUp() throws Exception
    {
        for (int i = 0; i < 10; i++)
        {
            target.add(i);
        }
    }
    
    @Test
    public void test()
    {
        QuickSort.sortByAsc(target);
        
        for (int i : target)
            System.out.println(i);
        
        QuickSort.sortByDesc(target);
        
        for (int i : target)
            System.out.println(i);
    }
    
}
