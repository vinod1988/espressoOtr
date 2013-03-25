package org.espressootr.lib.lang;

public class Number
{
    
    static final char[] NUM = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    
    static final int numCount = 10;
    
    public static boolean isNumber(final char gram)
    {
        
        boolean isNumberGram = false;
        int i = 0;
        for (; i < numCount; i++)
        {
            if (gram == NUM[i])
            {
                isNumberGram = true;
                break;
            }
        }
        
        return isNumberGram;
    }
    
}
