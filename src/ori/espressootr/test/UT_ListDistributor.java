package ori.espressootr.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.espressootr.lib.collection.ListDistributor;
import org.junit.Test;

public class UT_ListDistributor
{
    List<String> target = new ArrayList<String>();
    
    
    @Test
    public void test()
    {
        
        target.add("1");
        target.add("2");
        target.add("3");
        target.add("4");
        target.add("5");
        target.add("6");
        target.add("7");
        target.add("8");
        target.add("9");
        target.add("10");
        
        HashMap<Integer, List<String>> dist = ListDistributor.distributeList(6, target);
        System.out.println("size : "+dist.size());
        
        for (int i =0; i<dist.size(); i++)
        { 
            System.out.println(dist.get(i).size());
        }
        
        
        
    }
    
    
}
