package org.espressootr.lib.encoding;

 
public final class Encoding
{
 
    /**
     * @return encoding String
     */
    public static String getJVMEncoding()
    {
	String encoding = new java.io.OutputStreamWriter(System.out).getEncoding();
	return encoding;
    }

}
