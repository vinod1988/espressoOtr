package org.espressootr.lib.collection.cs;

 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.espressootr.lib.utils.InitUtil;

public class Shelfer
{
    private List<Canister> shelf = null;
    
    public Shelfer()
    {
        shelf = new ArrayList<Canister>();
    }
    
    public Shelfer(List<String> beans)
    {
        int i = 0;
        int elementSize = beans.size();
        
        char prevFrontChar = InitUtil.EMPTY_CHAR;
        char currentFrontChar = InitUtil.EMPTY_CHAR;
        
        if (shelf == null)
        {
            shelf = new ArrayList<Canister>();
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
                    
                    shelf.add(new Canister(String.valueOf(prevFrontChar), tmpList));
                    
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
            shelf.add(new Canister(tag, bean));
        }
    }
    
    private boolean containTag(String tag)
    {
        boolean isContained = true;
        int index = this.getCanisterIndex(tag);
        
        if (index < 0)
        {
            isContained = false;
        }
        
        return isContained;
        
    }
    
    public Canister get(String searchKeyword)
    {
        Canister canister = null;
        
        int index = this.getCanisterIndex(String.valueOf(searchKeyword.charAt(0)));
        
        if (index >= 0)
        {
            canister = this.shelf.get(index);
            
        }
        return canister;
    }
    
    public List<String> search(String searchKeyword)
    {
        List<String> searchResult = Collections.emptyList();
        Canister searchedCanister = this.get(searchKeyword);
        
        if (searchedCanister != null)
        {
            searchResult = searchedCanister.search(searchKeyword);
        }
        
        return searchResult;
    }
    
    private void qsort(List<Canister> sortingTarget)
    {
        Comparator<Canister> comparator = new Comparator<Canister>() {
            
            public int compare(Canister arg0, Canister arg1)
            {
                return arg0.getTag().compareTo(arg1.getTag());
            }
        };
        
        Collections.sort(sortingTarget, comparator);
        
    }
    
    private int getCanisterIndex(String searchTag)
    {
        
        int canisterIndex = -1;
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
                canisterIndex = midPt;
                break;
            }
            else if (result < FIND)
                start = midPt + 1;
            else
                end = midPt - 1;
        }
        
        return canisterIndex;
    }
    
}
