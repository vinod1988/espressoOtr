package org.espressootr.lib.lang;
 
public class Chinese
{ 

    public static boolean isChinese(char gram)
    {

	boolean isChineseGram = false;

	if (gram >= 0x4E00 && gram <= 0x9FFF)
	{
	    isChineseGram = true;
	    return isChineseGram;
	}
	else if (gram >= 0x2E80 && gram <= 0x2EFF)
	{
	    isChineseGram = true;
	    return isChineseGram;
	}

	else if (gram >= 0x3400 && gram <= 0x4DBF)
	{
	    isChineseGram = true;
	    return isChineseGram;
	}

	else if (gram >= 0xF900 && gram <= 0xFA77)
	{
	    isChineseGram = true;
	    return isChineseGram;
	}

	return isChineseGram;
    }
}