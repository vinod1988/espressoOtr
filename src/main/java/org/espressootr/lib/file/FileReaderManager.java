package org.espressootr.lib.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.encoding.Encoding;
 
 
public class FileReaderManager
{ 
    
    private FileReaderManager()
    {
        throw new AssertionError(); 
    }
    
  
    public static List<String> readLineFromFile(final String filePath) throws IOException
    {
        List<String> lineList = new ArrayList<String>();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), Encoding.getJVMEncoding()));
        
        String line = null;
        
        while ((line = in.readLine()) != null)
        {
            lineList.add(line.trim());
        }
        
        in.close();
        
        return lineList;
    }
}
