package org.espressootr.lib.encoding;


public class Unicode
{
    public static String getUnicodeFromString(String source)
    {
	return String.format("0X" + "%04X", source.codePointAt(0));
    }
 
}
