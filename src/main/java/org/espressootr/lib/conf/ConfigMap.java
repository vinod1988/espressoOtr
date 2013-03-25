package org.espressootr.lib.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ConfigMap
{
    private Map<String, Object> confKV = null;
    
 
    public ConfigMap()
    {
        confKV = new HashMap<String, Object>(); 
    }
    
    public ConfigMap(final Map<String, Object> confKV)
    {
        this.confKV = confKV;
    }
    
    public void set(final String key, final Object value)
    {
        if (this.confKV != null)
        {
            this.confKV.put(key, value);
        }
    }
    
    public boolean exist(final String key)
    {
        return confKV.containsKey(key);
    }
    
    public void put(final String key, final Object value)
    {
        confKV.put(key, value);
    }
    
    public String getStringValue(final String key)
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
    
    public String[] getStringArrayValue(final String key)
    {
        return (String[]) confKV.get(key);
    }
    
    public int[] getIntArrayValue(final String key)
    {
        return (int[]) confKV.get(key);
    }
    
    public int getIntValue(final String key)
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
    

    public void setToJvmProperties() 
    { 
        for (Entry<String, Object> obj : this.confKV.entrySet()) 
        { 
            System.setProperty(obj.getKey(), String.valueOf(obj.getValue())); 
        }  
    }
 
}
