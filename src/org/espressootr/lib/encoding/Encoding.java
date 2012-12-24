package org.espressootr.lib.encoding;

 
public class Encoding
{

    /**
     * @deprecated unused
     */
    private Encoding()
    {
	throw new AssertionError(); 
    }

    /**
     * @return encoding String
     */
    public static String getJVMEncoding()
    {
	String encoding = new java.io.OutputStreamWriter(System.out).getEncoding();
	return encoding;
    }

}
