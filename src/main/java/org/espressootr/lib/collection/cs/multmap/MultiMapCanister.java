package org.espressootr.lib.collection.cs.multmap;

import java.util.ArrayList;
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
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public MultiMapCanister(String tag, String beanKey, Object beanValue)
    {
        this.tag = tag;
        this.beans = new HashMap<String, List>();
        List mmValues = new ArrayList();
        mmValues.add(beanValue);
        this.beans.put(beanKey, mmValues);
    }
    
    @SuppressWarnings("rawtypes")
    public MultiMapCanister(String tag, Map<String, List> beans)
    {
        this.tag = tag;
        this.beans = new HashMap<String, List>(beans);
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
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    void add(String beanKey, List beanValues)
    { 
        if(this.beans.containsKey(beanKey))
        {
            List mmValues = this.beans.get(beanKey); 
            mmValues.addAll(beanValues);
            
        }
        else
        {
            this.beans.put(beanKey, beanValues);
        }
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    void add(String beanKey, Object beanValue)
    { 
        if(this.beans.containsKey(beanKey))
        {
            List mmValues = this.beans.get(beanKey); 
            mmValues.add(beanValue);
            
        }
        else
        {
            List mmValues = new ArrayList();
            mmValues.add(beanValue);
            this.beans.put(beanKey, mmValues);
        }
    }
    
    
    @SuppressWarnings("rawtypes")
    public List search(String searchKeyword)
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
