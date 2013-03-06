package org.espressootr.lib.collection.cs.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.espressootr.lib.json.JsonBodum;
import org.espressootr.lib.utils.InitUtil;

public class MapShelfer
{
    private List<MapCanister> shelf = null;
    
    public MapShelfer()
    {
        shelf = new ArrayList<MapCanister>();
    }
    
    public MapShelfer(Map<String, Object> beans)
    {
        int i = 0; 
        
        char prevFrontChar = InitUtil.EMPTY_CHAR;
        char currentFrontChar = InitUtil.EMPTY_CHAR;
        
        if (shelf == null)
        {
            shelf = new ArrayList<MapCanister>();
        }
        
        Map<String, Object> tmpMap = new HashMap<String, Object>();
        
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
                    shelf.add(new MapCanister(String.valueOf(prevFrontChar), tmpMap));
                    
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
    
    public void add(MapCanister MapCanister)
    {
        if (this.shelf != null) this.shelf.add(MapCanister);
        
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
            shelf.add(new MapCanister(tag, beanKey, beanValue));
        }
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
    
    public List<MapCanister> getShelf()
    {
        if (this.shelf != null)
            return new ArrayList<MapCanister>(this.shelf);
        else
            return null;
        
    }
    
    public MapCanister get(String searchKeyword)
    {
        MapCanister MapCanister = null;
        
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
        MapCanister searchedMapCanister = this.get(searchKeyword);
        
        if (searchedMapCanister != null)
        {
            searchResult = searchedMapCanister.search(searchKeyword);
        }
        
        return searchResult;
    }
    
    public void reArrange()
    {
        if (this.shelf != null) this.qsort(this.shelf);
    }
    
    private void qsort(List<MapCanister> sortingTarget)
    {
        Comparator<MapCanister> comparator = new Comparator<MapCanister>() {
            
            public int compare(MapCanister arg0, MapCanister arg1)
            {
                return arg0.getTag().compareTo(arg1.getTag());
            }
        };
        
        Collections.sort(sortingTarget, comparator);
        
    }
    
    private int getMapCanisterIndex(String searchTag)
    {
        int MapCanisterIndex = -1;
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
                MapCanisterIndex = midPt;
                break;
            }
            else if (result < FIND)
                start = midPt + 1;
            else
                end = midPt - 1;
        }
        
        return MapCanisterIndex;
    }
    
    public HashMap<String, MapCanister> toHashMap()
    {
        HashMap<String, MapCanister> shelfMap = new HashMap<String, MapCanister>();
        
        for (MapCanister MapCanister : this.shelf)
        {
            shelfMap.put(MapCanister.getTag(), MapCanister);
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
