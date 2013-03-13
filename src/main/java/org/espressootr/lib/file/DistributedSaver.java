package org.espressootr.lib.file;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.espressootr.lib.collection.ListDistributor; 
import org.espressootr.lib.string.StringAppender;

public class DistributedSaver
{
    private int distCount = 1;
    
    private String filePath = "./"; // default current directory.
    
    private String fileName = "db";
    
    private String fileExt = "txt";
    
    public String getFileExt()
    {
        return fileExt;
    }
    
    public void setFileExt(String fileExt)
    {
        this.fileExt = fileExt;
    }
    
    public String getFileName()
    {
        return fileName;
    }
    
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    public int getDistCount()
    {
        return distCount;
    }
    
    public void setDistCount(int distCount)
    {
        this.distCount = distCount;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void save(List<String> willSaveList)
    {
        ExecutorService concurrentService = Executors.newFixedThreadPool(this.distCount);
        
        Map<Integer, List> distMap = ListDistributor.distributeListToSubList(this.distCount, willSaveList);
        
        int size = distMap.size();
        
        for (int i = 0; i < size; i++)
        {
            filePath = StringAppender.mergeToStr(this.filePath, this.fileName, String.valueOf(i), ".", this.fileExt);
            
            concurrentService.execute(new SaveRunnableThread((List<String>) distMap.get(i), filePath));
        }
        
        concurrentService.shutdown();
        
    }
    
}
