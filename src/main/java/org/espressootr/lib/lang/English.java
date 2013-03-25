package org.espressootr.lib.lang;
 
public class English
{

    private static final char UPPERCASE_A = 'A';
    private static final char UPPERCASE_Z = 'Z';
    private static final char LOWERCASE_A = 'a';
    private static final char LOWERCASE_Z = 'z';

    
    public static boolean isEnglish(final char gram)
    {

	boolean isAlpabetGram = false;
	if ((LOWERCASE_A <= gram && gram <= LOWERCASE_Z)
		|| (UPPERCASE_A <= gram && gram <= UPPERCASE_Z))
	{
	    isAlpabetGram = true;
	}
	else
	{
	    isAlpabetGram = false;
	}

	return isAlpabetGram;
    }
    
}
