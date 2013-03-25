package org.espressootr.lib.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DistributedLoader
{
    
    public Map<String, List<String>> load(final List<String> filePathList) throws Exception
    {
        Map<String, List<String>> filePathContents = new HashMap<String, List<String>>();
        ExecutorService concurrentService = Executors.newCachedThreadPool();
        List<Future<StringLoadResult>> loadThResultList = new ArrayList<Future<StringLoadResult>>();
        
        for (String filePath : filePathList)
        {
            loadThResultList.add(concurrentService.submit(new LoadCallableThread(filePath)));
        }
        
        for (Future<StringLoadResult> loadResultFuture : loadThResultList)
        {
            filePathContents.put(loadResultFuture.get().getLoadedFilePath(), loadResultFuture.get().getLoadedList());
        }
        
        
        concurrentService.shutdown();
        
        return filePathContents;
        
    }
    
}
