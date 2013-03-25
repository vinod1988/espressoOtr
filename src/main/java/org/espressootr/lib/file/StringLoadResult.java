package org.espressootr.lib.file;

import java.util.List;

public class StringLoadResult
{
    private String loadedFilePath = null;
    
    private List<String> loadedList = null;
    
    public String getLoadedFilePath()
    {
        return loadedFilePath;
    }
    
    public void setLoadedFilePath(final String loadedFilePath)
    {
        this.loadedFilePath = loadedFilePath;
    }
    
    public List<String> getLoadedList()
    {
        return loadedList;
    }
    
    public void setLoadedList(final List<String> loadedList)
    {
        this.loadedList = loadedList;
    }
    
}
