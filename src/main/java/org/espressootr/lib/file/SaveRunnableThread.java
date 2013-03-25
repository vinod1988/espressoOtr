package org.espressootr.lib.file;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.espressootr.lib.encoding.Encoding;

public class SaveRunnableThread implements Runnable
{
    private List<String> willSaveList = null;
    
    private String filePath = null;
    
    @SuppressWarnings("unused")
    private SaveRunnableThread()
    {
        throw new AssertionError();
    }
    
    public SaveRunnableThread(final List<String> willSaveList, final String filePath)
    {
        this.willSaveList = willSaveList;
        this.filePath = filePath;
    }
    
    @Override
    public void run()
    {
        BufferedWriter bfWriter = null;
        
        try
        {
            
            if (this.willSaveList == null || this.filePath == null) throw new Exception("savelist is null or filePath is null.");
            
            bfWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.filePath, false), Encoding.getJVMEncoding()));
            
            for (String savedStr : this.willSaveList)
            {
                bfWriter.write(savedStr);
                bfWriter.newLine();
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (bfWriter != null)
            {
                try
                {
                    bfWriter.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
}
