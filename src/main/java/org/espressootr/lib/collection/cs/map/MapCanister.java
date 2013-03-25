package org.espressootr.lib.collection.cs.map;

import java.util.HashMap;

import java.util.Map;

import org.espressootr.lib.json.JsonBodum;

import org.espressootr.lib.utils.InitUtil;

public class MapCanister
{
    private String tag = InitUtil.EMPTY_STRING;
    
    private Map<String, Object> beans = null;
    
    @SuppressWarnings("unused")
    private MapCanister()
    {
        
    }
    
    public MapCanister(final String tag, final String beanKey, final Object beanValue)
    {
        this.tag = tag;
        this.beans = new HashMap<String, Object>();
        this.beans.put(beanKey, beanValue);
    }
    
    public MapCanister(final String tag, final Map<String, Object> beans)
    {
        this.tag = tag;
        this.beans = new HashMap<String, Object>(beans);
    }
    
  
    public String getTag()
    {
        return tag;
    }
    
    public Map<String, Object> getBeans()
    {
        return beans;
    }
    
    public String toJson()
    {
        return JsonBodum.toJson(this);
    }
    
    void add(final String beanKey, final Object beanValue)
    {
        this.beans.put(beanKey, beanValue);
    }
    
    public Object search(final String searchKeyword)
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
