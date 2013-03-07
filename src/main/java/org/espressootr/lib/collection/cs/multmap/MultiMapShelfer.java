package org.espressootr.lib.collection.cs.multmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.espressootr.lib.json.JsonBodum;
import org.espressootr.lib.utils.InitUtil;

public class MultiMapShelfer
{
    
 private List<MultiMapCanister> shelf = null;
    
    public MultiMapShelfer()
    {
        shelf = new ArrayList<MultiMapCanister>();
    }
    
    @SuppressWarnings("rawtypes")
    public MultiMapShelfer(Map<String, List> beans)
    {
        int i = 0;
        
        char prevFrontChar = InitUtil.EMPTY_CHAR;
        char currentFrontChar = InitUtil.EMPTY_CHAR;
        
        if (shelf == null)
        {
            shelf = new ArrayList<MultiMapCanister>();
        }
        
        Map<String, List> tmpMap = new HashMap<String, List>();
        
        for (String beanKey : beans.keySet())
        {
            currentFrontChar = beanKey.charAt(0);
            
            if (i == 0) prevFrontChar = currentFrontChar;
            
            if (prevFrontChar == currentFrontChar)
            {
                tmpMap.put(beanKey, beans.get(beanKey));
            }
            else
            {
                if (tmpMap.size() != 0)
                {
                    shelf.add(new MultiMapCanister(String.valueOf(prevFrontChar), tmpMap));
                    
                    tmpMap.clear();
                    tmpMap.put(beanKey, beans.get(beanKey));
                }
            }
            
            prevFrontChar = currentFrontChar;
            i++;
        }
        
        this.qsort(this.shelf);
        
    }
    
    public List<String> getTags()
    {
        int i = 0;
        int shelfSize = this.shelf.size();
        
        List<String> tags = new ArrayList<String>();
        
        for (; i < shelfSize; i++)
        {
            tags.add(this.shelf.get(i).getTag());
        }
        
        return tags;
    }
    
    public int size()
    {
        return shelf.size();
    }
    
    public void clear()
    {
        shelf.clear();
    }
    
    public void add(MultiMapCanister multiMapCanister)
    {
        if (this.shelf != null) this.shelf.add(multiMapCanister);
        
        this.reArrange();
    }
    
    public void add(String beanKey, Object beanValue)
    {
        
        String tag = String.valueOf(beanKey.charAt(0));
        
        boolean isContain = this.containTag(tag);
        
        if (isContain)
        {
            this.get(tag).add(beanKey, beanValue);
        }
        else
        {
            shelf.add(new MultiMapCanister(tag, beanKey, beanValue));
        }
        
        this.qsort(this.shelf);
    }
    
    public void remove(int index)
    {
        if (this.shelf.size() != 0)
        {
            this.shelf.remove(index);
        }
    }
    
    public void remove(String tag)
    {
        int index = getMapCanisterIndex(tag);
        
        this.remove(index);
        
    }
    
    private boolean containTag(String tag)
    {
        boolean isContained = true;
        int index = this.getMapCanisterIndex(tag);
        
        if (index < 0)
        {
            isContained = false;
        }
        
        return isContained;
        
    }
    
    public List<MultiMapCanister> getShelf()
    {
        if (this.shelf != null)
            return new ArrayList<MultiMapCanister>(this.shelf);
        else
            return null;
        
    }
    
    public MultiMapCanister get(String searchKeyword)
    {
        MultiMapCanister MapCanister = null;
        
        int index = this.getMapCanisterIndex(String.valueOf(searchKeyword.charAt(0)));
        
        if (index >= 0)
        {
            MapCanister = this.shelf.get(index);
        }
        return MapCanister;
    }
    
    public Object search(String searchKeyword)
    {
        Object searchResult = new Object();
        
        MultiMapCanister searchedMultiMapCanister = this.get(searchKeyword);
        
        if (searchedMultiMapCanister != null)
        {
            searchResult = searchedMultiMapCanister.search(searchKeyword);
        }
        
        return searchResult;
    }
    
    public void reArrange()
    {
        if (this.shelf != null) this.qsort(this.shelf);
    }
    
    private void qsort(List<MultiMapCanister> sortingTarget)
    {
        Comparator<MultiMapCanister> comparator = new Comparator<MultiMapCanister>() {
            
            public int compare(MultiMapCanister arg0, MultiMapCanister arg1)
            {
                return arg0.getTag().compareTo(arg1.getTag());
            }
        };
        
        Collections.sort(sortingTarget, comparator);
        
    }
    
    private int getMapCanisterIndex(String searchTag)
    {
        int mapCanisterIndex = -1;
        int start, end, midPt;
        final int FIND = 0;
        
        start = 0;
        end = this.shelf.size() - 1;
        
        while (start <= end)
        {
            midPt = (start + end) / 2;
            int result = this.shelf.get(midPt).getTag().compareTo(searchTag);
            
            if (result == FIND)
            {
                mapCanisterIndex = midPt;
                break;
            }
            else if (result < FIND)
                start = midPt + 1;
            else
                end = midPt - 1;
        }
        
        return mapCanisterIndex;
    }
    
    public HashMap<String, MultiMapCanister> toHashMap()
    {
        HashMap<String, MultiMapCanister> shelfMap = new HashMap<String, MultiMapCanister>();
        
        for (MultiMapCanister multiMapCanister : this.shelf)
        {
            shelfMap.put(multiMapCanister.getTag(), multiMapCanister);
        }
        
        return shelfMap;
    }
    
    public String toJson()
    {
        return JsonBodum.toJson(this.shelf);
    }
    
    @Override
    public String toString()
    {
        StringBuilder toStrSb = new StringBuilder();
        
        for (int i = 0; i < this.shelf.size(); i++)
        {
            
            toStrSb.append(this.shelf.get(i).getTag());
            toStrSb.append(";");
            
            toStrSb.append(this.shelf.get(i).getbeans());
            toStrSb.append("\n");
            
        }
        
        return toStrSb.toString();
        
    }
}
