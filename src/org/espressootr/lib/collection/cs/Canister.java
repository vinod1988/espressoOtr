package org.espressootr.lib.collection.cs; 

import java.util.ArrayList;
import java.util.List;
 
import org.espressootr.lib.search.Searcher;
import org.espressootr.lib.sort.QuickSort;
import org.espressootr.lib.utils.InitUtil;
 
public class Canister
{
    private List<String> beans = null;
    
    private String tag = InitUtil.EMPTY_STRING;
    
    public Canister(String tag, List<String> beans)
    {
        this.tag = tag;
        this.beans = new ArrayList<String>(beans);
    }
    
    public Canister(String tag, String bean)
    {
        this.tag = tag;
        this.beans = new ArrayList<String>();
        this.beans.add(bean);
    }
    
    public List<String> getbeans()
    {
        return beans;
    }
    
    public String getTag()
    {
        return tag;
    }
    
    void add(String element)
    {
        this.beans.add(element);
        QuickSort.sort(this.beans);
    }
    
    List<String> search(String searchBean)
    {
        List<String> searchElement = new ArrayList<String>();
        List<Integer> indexList = Searcher.extIncSearch(this.beans, searchBean);
        
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
