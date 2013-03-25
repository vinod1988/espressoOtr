package org.espressootr.lib.utils;

public class IndexUtil
{
    
    public static int[] createIntIndex(final int size)
    {
        int[] index = new int[size];
        
        for (int i = 0; i < size; i++)
            index[i] = 0;
        
        return index;
    }
    
    public static int[] createIntIndex(final int size, final int initValue)
    {
        int[] index = new int[size];
        
        for (int i = 0; i < size; i++)
            index[i] = initValue;
        
        return index;
    }
    
    public static String[] createStringIndex(final int size)
    {
        String[] index = new String[size];
        
        for (int i = 0; i < size; i++)
            index[i] = InitUtil.EMPTY_STRING;
        
        return index;
        
    }
    
    public static String[] createStringIndex(final int size, final String initValue)
    {
        String[] index = new String[size];
        
        for (int i = 0; i < size; i++)
            index[i] = initValue;
        
        return index;
        
    }
    
}
