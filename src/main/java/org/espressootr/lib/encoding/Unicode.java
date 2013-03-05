package org.espressootr.lib.encoding;


public final class Unicode
{
    public static String getUnicodeFromString(String source, int index)
    {
	return String.format("0X" + "%04X", source.codePointAt(index));
    }
 
}
