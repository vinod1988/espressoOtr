package org.espressootr.lib.collection.cs.list;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;

import org.espressootr.lib.json.JsonBodum;
import org.espressootr.lib.search.BeanSearch;
import org.espressootr.lib.search.ExtendedInclusiveBiSearch;

import org.espressootr.lib.sort.QuickSort;
import org.espressootr.lib.utils.InitUtil;

public class ListCanister 
{
    
    private String tag = InitUtil.EMPTY_STRING;
    private List<String> beans = null;
    private BeanSearch searcher = null;
    
    @SuppressWarnings("unused")
    private ListCanister()
    {
        searcher = new ExtendedInclusiveBiSearch();
 
        
    }
     
    public ListCanister(String tag, String bean)
    {
        this.tag = tag;
        this.beans = new ArrayList<String>();
        this.beans.add(bean);
    }
    
    public ListCanister(String tag, List<String> beans)
    {
        this.tag = tag;
        this.beans = new ArrayList<String>(beans);
    }
    
    public ListCanister(String tag, List<String> beans, boolean isSorted)
    {
        this.tag = tag;
        this.beans = new ArrayList<String>(beans);
        
        if (isSorted == false)
        {
            QuickSort.sort(this.beans);
        }
    }
    
    
    public List<String> getBeans()
    {
        return beans;
    }
    
    public String getTag()
    {
        return tag;
    }
    
    public BeanSearch getSearcher()
    {
        return searcher;
    }
    
    public void setSearcher(BeanSearch searcher)
    {
        this.searcher = searcher;
    }
    
    public String toJson()
    {
        return JsonBodum.toJson(this);
    }
    
    public HashMap<String, List<String>> toHashMap()
    {
        HashMap<String, List<String>> canisterMap = new HashMap<String, List<String>>();
        
        canisterMap.put(this.getTag(), this.beans);
        
        return canisterMap;
    }
    
    
    void add(String element)
    {
        this.beans.add(element);
        QuickSort.sort(this.beans);
    }
    
    List<String> search(String searchBean)
    {
        List<String> searchElement = new ArrayList<String>();
        List<Integer> indexList = searcher.search(this.beans, searchBean);
        
        int i = 0;
        int indexListSize = indexList.size();
        
        if (indexList.size() > 0)
        {
            for (; i < indexListSize; i++)
            {
                searchElement.add(this.beans.get(indexList.get(i)));
            }
        }
        
        return searchElement;
        
    }
    
    @Override
    public String toString()
    {
        StringBuilder canSb = new StringBuilder();
        canSb.append("tag:").append(tag).append("\n");
        canSb.append("beans:").append(beans.toString()).append("\n");
        
        return canSb.toString();
    }

    
    
}
