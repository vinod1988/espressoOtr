package org.espressootr.lib.file;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.espressootr.lib.encoding.Encoding;
 
 
public class FileWriterManager
{

    private FileWriterManager()
    {
        throw new AssertionError();
    }
    
     
    public static void writeLineToFile(final String filePath, final String content,final boolean append) throws IOException
    { 
	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, append), Encoding.getJVMEncoding()));

	out.write(content);
	out.newLine();

	out.close();

    }
    
    public static void writeToFile(final String filePath, final String content, final boolean append) throws IOException
    {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, append), Encoding.getJVMEncoding()));

        out.write(content); 
        out.close();
    }

}
