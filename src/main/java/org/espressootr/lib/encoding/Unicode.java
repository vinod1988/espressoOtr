package org.espressootr.lib.encoding;


public final class Unicode
{
    public static String getUnicodeFromString(final String source, final int index)
    {
	return String.format("0X" + "%04X", source.codePointAt(index));
    }
    
    
 
}
