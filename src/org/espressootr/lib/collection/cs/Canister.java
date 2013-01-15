package org.espressootr.lib.collection.cs;

import java.util.ArrayList;
import java.util.List;

public class Canister
{
    private List<String> elements = null; 
    
    private String tag = "";
     
    public Canister(String tag, List<String> tmpList)
    {
        this.tag = tag; 
        this.elements = new ArrayList<String>(tmpList);
    }

    public List<String> getElements()
    {
        return elements;
    }

    public void setElements(List<String> elements)
    {
        this.elements = elements;
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    
    @Override
    public String toString()
    {
        StringBuilder canSb = new StringBuilder();
        canSb.append("tag:").append(tag).append("\n");
        canSb.append("elements:").append(elements.toString());
        
        return canSb.toString(); 
    }
    
    
}
