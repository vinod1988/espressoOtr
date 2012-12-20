package org.espressootr.lib.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.espressootr.lib.utils.InitUtil;

public class ListDistributor
{
    public static HashMap<Integer, List<String>> distributeListToSubList(int subListCount, List<String> targetList)
    {
        HashMap<Integer, List<String>> distributedList = new HashMap<Integer, List<String>>();
        
        if (subListCount == InitUtil.ZERO)
        {
            distributedList.put(0, new ArrayList<String>(targetList));
        }
        else
        {
            
            for (int i = 0; i < subListCount; i++)
            {
                distributedList.put(i, new ArrayList<String>());
            }
            
            int eachCapacity = targetList.size() / subListCount;
            
            int index = 0;
            for (int i = 0; i < targetList.size(); i++)
            { 
                distributedList.get(index).add(targetList.get(i));
                
                if (index != distributedList.size()-1)
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
    
    public static HashMap<Integer, List<String>> distributeListToSameCapacity(int capacityCount, List<String> targetList)
    {
        HashMap<Integer, List<String>> distributedList = new HashMap<Integer, List<String>>();
        
        if (capacityCount <= InitUtil.ZERO)
        {
            distributedList.put(0, new ArrayList<String>(targetList));
        }
        else
        {
            int toIndex = InitUtil.ZERO;
            int index = InitUtil.ZERO;
            
            for (int i = 0; i < targetList.size();)
            {
                toIndex = i + capacityCount;
                
                if (i > targetList.size())
                {
                    break;
                }
                
                if (toIndex > targetList.size()) toIndex = targetList.size();
                
                distributedList.put(index, new ArrayList<String>(targetList.subList(i, toIndex)));
                
                index++;
                i += capacityCount;
                
            }// for
        }
        
        return distributedList;
        
    }
}
