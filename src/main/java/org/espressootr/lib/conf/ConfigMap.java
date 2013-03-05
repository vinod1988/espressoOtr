package org.espressootr.lib.conf;

import java.util.HashMap;
import java.util.Map;

public class ConfigMap
{
    private Map<String, Object> confKV = null;
    
 
    public ConfigMap()
    {
        confKV = new HashMap<String, Object>(); 
    }
    
    public ConfigMap(Map<String, Object> confKV)
    {
        this.confKV = confKV;
    }
    
    public void set(String key, Object value)
    {
        if (this.confKV != null)
        {
            this.confKV.put(key, value);
        }
    }
    
    public boolean exist(String key)
    {
        return confKV.containsKey(key);
    }
    
    public void put(String key, Object value)
    {
        confKV.put(key, value);
    }
    
    public String getStringValue(String key)
    {
        String value = "";
        
        if (confKV.containsKey(key))
        {
            value = confKV.get(key).toString();
        }
        else
        {
            value = "";
        }
        
        return value;
    }
    
    public String[] getStringArrayValue(String key)
    {
        return (String[]) confKV.get(key);
    }
    
    public int[] getIntArrayValue(String key)
    {
        return (int[]) confKV.get(key);
    }
    
    public int getIntValue(String key)
    {
        return Integer.valueOf(confKV.get(key).toString());
    }
    
    public void clear()
    {
        this.confKV.clear();
    }
    
    @Override
    public String toString()
    {
        return this.confKV.toString();
    }
}
