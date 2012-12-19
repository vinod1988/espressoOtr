package org.espressootr.lib.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.espressootr.lib.utils.InitUtil;

public class ListDistributor
{
    
    public static HashMap<Integer, List<String>> distributeListToSameCapacity(int capacityCount, List<String> targetList)
    { 
        HashMap<Integer, List<String>> distributedList = new HashMap<Integer, List<String>>();
        
        if (capacityCount == InitUtil.ZERO)
        {
            distributedList.put(0, new ArrayList<String>(targetList));
        }
        else
        {
            int fromIndex = 0;
            int toIndex = capacityCount;
            
            int index = 0;
            for (;;)
            {
                if (targetList.size() < toIndex)
                {
                    toIndex = targetList.size();
                }
                
                distributedList.put(index, new ArrayList<String>(targetList.subList(fromIndex, toIndex)));
                index++;
                
                for (int i = fromIndex; i < toIndex; i++)
                {
                    targetList.remove(0);
                }
                
                if (targetList.size() == InitUtil.ZERO)
                {
                    break;
                }
                
            }// for(;;)
        }
        
        return distributedList;
        
    }
}
