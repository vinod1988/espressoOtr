package org.espressootr.lib.lang;

public class Number
{

    public static boolean isNumber(char gram)
    {
	boolean isNumberGram = false;

	try
	{
	    Integer.valueOf(String.valueOf(gram));
	    isNumberGram = true;

	}
	catch (Exception e)
	{
	    isNumberGram = false;
	}

	return isNumberGram;
    }
}
