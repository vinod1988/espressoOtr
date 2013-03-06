package org.espressootr.lib.collection.cs.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.espressootr.lib.json.JsonBodum;
import org.espressootr.lib.utils.InitUtil;

public class ListShelfer
{
    private List<ListCanister> shelf = null;
    
    public ListShelfer()
    {
        shelf = new ArrayList<ListCanister>();
    }
    
    public ListShelfer(List<String> beans)
    {
        int i = 0;
        int elementSize = beans.size();
        
        char prevFrontChar = InitUtil.EMPTY_CHAR;
        char currentFrontChar = InitUtil.EMPTY_CHAR;
        
        if (shelf == null)
        {
            shelf = new ArrayList<ListCanister>();
        }
        
        List<String> tmpList = new ArrayList<String>();
        
        for (; i < elementSize; i++)
        {
            currentFrontChar = beans.get(i).charAt(0);
            
            if (i == 0) prevFrontChar = currentFrontChar;
            
            if (prevFrontChar == currentFrontChar)
            {
                tmpList.add(beans.get(i));
            }
            else
            {
                if (tmpList.size() != 0)
                {
                    shelf.add(new ListCanister(String.valueOf(prevFrontChar), tmpList));
                    
                    tmpList.clear();
                    tmpList.add(beans.get(i));
                }
            }
            
            prevFrontChar = currentFrontChar;
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
    
    public void add(ListCanister ListCanister)
    {
        if (this.shelf != null) this.shelf.add(ListCanister);
        
        this.reArrange();
    }
    
    public void add(String bean)
    {
        String tag = String.valueOf(bean.charAt(0));
        
        boolean isContain = this.containTag(tag);
        
        if (isContain)
        {
            this.get(tag).add(bean);
        }
        else
        {
            shelf.add(new ListCanister(tag, bean));
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
        int index = getListCanisterIndex(tag);
        
        this.remove(index);
        
    }
    
    private boolean containTag(String tag)
    {
        boolean isContained = true;
        int index = this.getListCanisterIndex(tag);
        
        if (index < 0)
        {
            isContained = false;
        }
        
        return isContained;
        
    }
    
    public List<ListCanister> getShelf()
    {
        if (this.shelf != null)
            return new ArrayList<ListCanister>(this.shelf);
        else
            return null;
        
    }
    
    public ListCanister get(String searchKeyword)
    {
        ListCanister ListCanister = null;
        
        int index = this.getListCanisterIndex(String.valueOf(searchKeyword.charAt(0)));
        
        if (index >= 0)
        {
            ListCanister = this.shelf.get(index);
            
        }
        return ListCanister;
    }
    
    public List<String> search(String searchKeyword)
    {
        List<String> searchResult = Collections.emptyList();
        ListCanister searchedListCanister = this.get(searchKeyword);
        
        if (searchedListCanister != null)
        {
            searchResult = searchedListCanister.search(searchKeyword);
        }
        
        return searchResult;
    }
    
    public void reArrange()
    {
        if (this.shelf != null) this.qsort(this.shelf);
    }
    
    private void qsort(List<ListCanister> sortingTarget)
    {
        Comparator<ListCanister> comparator = new Comparator<ListCanister>() {
            
            public int compare(ListCanister arg0, ListCanister arg1)
            {
                return arg0.getTag().compareTo(arg1.getTag());
            }
        };
        
        Collections.sort(sortingTarget, comparator);
        
    }
    
    private int getListCanisterIndex(String searchTag)
    {
        int ListCanisterIndex = -1;
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
                ListCanisterIndex = midPt;
                break;
            }
            else if (result < FIND)
                start = midPt + 1;
            else
                end = midPt - 1;
        }
        
        return ListCanisterIndex;
    }
    
    public HashMap<String, ListCanister> toHashMap()
    {
        HashMap<String, ListCanister> shelfMap = new HashMap<String, ListCanister>();
        
        for (ListCanister ListCanister : this.shelf)
        {
            shelfMap.put(ListCanister.getTag(), ListCanister);
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
