package org.espressootr.lib.collection.cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Shelfer
{
    private HashMap<String, Canister> shelf = null;
    
    public Shelfer()
    {
        shelf = new HashMap<String, Canister>();
    }
    
    public Shelfer(List<String> elements)
    {
        if (shelf == null)
        {
            shelf = new HashMap<String, Canister>();
        }
        
        char prevFrontChar = ' ';
        char currentFrontChar = ' ';
        
        List<String> tmpList = new ArrayList<String>();
        String tag = "";
        int i = 0;
        int size = elements.size();
        
        for (; i < size; i++)
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
