package org.espressootr.lib.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtil
{
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List getValueList(Map targetMap)
    {
        List valueList = new ArrayList();
        
        for (Object key : targetMap.keySet())
        { 
            valueList.add(targetMap.get(key));
        }
        
        return valueList; 
        
    }
    
}
