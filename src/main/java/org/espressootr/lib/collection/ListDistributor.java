package org.espressootr.lib.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.espressootr.lib.utils.InitUtil;

public class ListDistributor
{
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static HashMap<Integer, List> distributeListToSubList(final int subListCount, final List targetList)
    {
        HashMap<Integer, List> distributedList = new HashMap<Integer, List>();
        int targetListCount = targetList.size();
        
        if (subListCount == InitUtil.ZERO)
        {
            distributedList.put(0, new ArrayList(targetList));
        }
        else
        {
            for (int i = 0; i < subListCount; i++)
                distributedList.put(i, new ArrayList<Object>());
            
            int eachCapacity = targetList.size() / subListCount;
            
            int index = 0;
            
            for (int i = 0; i < targetListCount; i++)
            {
                distributedList.get(index).add(targetList.get(i));
                
                if (index != distributedList.size() - 1)
                {
                    if (distributedList.get(index).size() == eachCapacity)
                    {
                        index++;
                    }
                }
                
            }
        }
        
        return distributedList;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static HashMap<Integer, List> distributeListToSameCapacity(final int capacityCount, final List targetList)
    {
        HashMap<Integer, List> distributedList = new HashMap<Integer, List>();
        
        if (capacityCount <= InitUtil.ZERO)
        {
            distributedList.put(0, new ArrayList(targetList));
        }
        else
        {
            int toIndex = InitUtil.ZERO;
            int index = InitUtil.ZERO;
            
            for (int i = 0; i < targetList.size();)
            {
                toIndex = i + capacityCount;
                
                if (i > targetList.size()) break;
                
                if (toIndex > targetList.size()) toIndex = targetList.size();
                
                distributedList.put(index, new ArrayList(targetList.subList(i, toIndex)));
                
                index++;
                i += capacityCount;
                
            }// for
        }
        
        return distributedList;
        
    }
}
