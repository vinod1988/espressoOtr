package org.espressootr.lib.collection.cs.multmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.espressootr.lib.json.JsonBodum;
import org.espressootr.lib.utils.InitUtil;

public class MultiMapCanister
{
      
  private String tag = InitUtil.EMPTY_STRING;
    
    @SuppressWarnings("rawtypes")
    private Map<String, List> beans = null;
    
    @SuppressWarnings("unused")
    private MultiMapCanister()
    {
        
    }
    
    @SuppressWarnings("rawtypes")
    public MultiMapCanister(String tag, String beanKey, List beanValues)
    {
        this.tag = tag;
        this.beans = new HashMap<String, List>();
        this.beans.put(beanKey, beanValues);
    }
    
    @SuppressWarnings("rawtypes")
    public MultiMapCanister(String tag, Map<String, List> beans)
    {
        this.tag = tag;
        this.beans = new HashMap<String, List>(beans);
    }
    
    @SuppressWarnings("rawtypes")
    public Map<String, List> getbeans()
    {
        return beans;
    }
    
    public String getTag()
    {
        return tag;
    }
    
    @SuppressWarnings("rawtypes")
    public Map<String, List> getBeans()
    {
        return beans;
    }
    
    public String toJson()
    {
        return JsonBodum.toJson(this);
    }
    
    @SuppressWarnings("rawtypes")
    void add(String beanKey, List beanValues)
    {
        this.beans.put(beanKey, beanValues);
    }
    
    public Object search(String searchKeyword)
    {
        return this.beans.get(searchKeyword);
        
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
