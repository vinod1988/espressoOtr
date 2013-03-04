package org.espressootr.lib.lang;
 
public class Korean
{
    private static final int HANGUL_UNICODE_START = 0xAC00;
    private static final int HANGUL_UNICODE_END = 0xD7AF;
 
    
    public static boolean isHangul(char gram)
    {
	boolean isHangulGram = false;

	if ((HANGUL_UNICODE_START <= gram) && (gram <= HANGUL_UNICODE_END))
	    isHangulGram = true;
	else
	    isHangulGram = false;

	return isHangulGram;
    }

    
}
