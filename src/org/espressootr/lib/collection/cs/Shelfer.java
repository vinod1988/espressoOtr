package org.espressootr.lib.collection.cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.espressootr.lib.utils.CapacityUtils;
import org.espressootr.lib.utils.InitUtil;

public class Shelfer
{
    private HashMap<String, Canister> shelf = null;
    
    public Shelfer()
    {
        shelf = new HashMap<String, Canister>();
    }
    
    public Shelfer(List<String> elements)
    {
        int i = InitUtil.ZERO;
        int elementSize = elements.size();
        
        char prevFrontChar = InitUtil.EMPTY_CHAR;
        char currentFrontChar = InitUtil.EMPTY_CHAR;
        
        String tag = InitUtil.EMPTY_STRING;
        
        if (shelf == null)
        {
            shelf = new HashMap<String, Canister>(CapacityUtils.adjustInitialCapacity(elements.size()));
        }
        
        List<String> tmpList = new ArrayList<String>();
        
        for (; i < elementSize; i++)
        {
            currentFrontChar = elements.get(i).charAt(0);
            
            if (prevFrontChar == currentFrontChar)
            {
                tmpList.add(elements.get(i));
            }
            else
            {
                if (tmpList.size() != 0)
                {
                    tag = String.valueOf(prevFrontChar);
                    
                    shelf.put(tag, new Canister(tag, tmpList));
                    
                    tmpList.clear();
                    tmpList.add(elements.get(i));
                }
            }
            
            prevFrontChar = currentFrontChar;
        }
        
    }
    
    public Canister getCanister(String key)
    {
        return shelf.get(String.valueOf(key.charAt(0)));
    }
    
    public Set<String> getTags()
    {
        return new HashSet<String>(shelf.keySet());
    }
    
    public Set<String> getSortedTags()
    {
        return new TreeSet<String>(shelf.keySet());
    }
    
    public int size()
    {
        return shelf.size();
    }
    
    public void clear()
    {
        shelf.clear();
    }
    
}
