package org.espressootr.lib.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionConverter
{
    
    public static List<Object> array2List(final Object[] array)
    {
        List<Object> convertedList = new ArrayList<Object>();
        for (Object obj : array)
            convertedList.add(obj);
        
        return convertedList;
        
    }
    
    public static Object[] list2Array(final List<Object> list)
    {
        int count = list.size();
        Object[] convertedArray = new Object[count];
        for (int i = 0; i < count; i++)
            convertedArray[i] = list.get(i);
        
        return convertedArray;
        
    }
    
    public static String[] stringList2Array(final List<String> list)
    {
        int count = list.size();
        String[] convertedArray = new String[count];
        for (int i = 0; i < count; i++)
            convertedArray[i] = list.get(i);
        
        return convertedArray;
    }
    
    public static List<String> stringArray2List(final String[] array)
    {
        List<String> convertedList = new ArrayList<String>();
        for (String obj : array)
            convertedList.add(obj);
        
        return convertedList;
        
    }
    
    public static int[] intList2Array(final List<Integer> list)
    {
        int count = list.size();
        int[] convertedArray = new int[count];
        for (int i = 0; i < count; i++)
            convertedArray[i] = list.get(i);
        
        return convertedArray;
    }
    
    public static List<Integer> intArray2List(final int[] array)
    {
        List<Integer> convertedList = new ArrayList<Integer>();
        for (Integer obj : array)
            convertedList.add(obj);
        
        return convertedList;
        
    }
    
}
