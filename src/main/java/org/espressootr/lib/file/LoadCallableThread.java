package org.espressootr.lib.file;

import java.util.List;
import java.util.concurrent.Callable;

public class LoadCallableThread implements Callable<StringLoadResult>
{
    private String filePath = null;
    
    @SuppressWarnings("unused")
    private LoadCallableThread()
    {
        throw new AssertionError();
        
    }
    
    public LoadCallableThread(final String filePath)
    {
        this.filePath = filePath;
    }
    
    @Override
    public StringLoadResult call() throws Exception
    {
        if (this.filePath == null) throw new Exception("filePath is null.");
        
        List<String> contentFromFile = FileReaderManager.readLineFromFile(this.filePath);
        
        StringLoadResult slr = new StringLoadResult();
        slr.setLoadedFilePath(this.filePath);
        slr.setLoadedList(contentFromFile);
        
        return slr;
        
    }
}
