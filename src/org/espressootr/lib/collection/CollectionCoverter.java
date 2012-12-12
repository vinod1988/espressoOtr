package org.espressootr.lib.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionCoverter
{

    public static List<Object> array2List(Object[] array)
    {
	List<Object> convertedList = new ArrayList<Object>();
	for (Object obj : array)
	{
	    convertedList.add(obj);
	}

	return convertedList;

    }

    public static Object[] list2Array(List<Object> list)
    {
	int count = list.size();
	Object[] convertedArray = new Object[count];
	for (int i = 0; i < count; i++)
	{
	    convertedArray[i] = list.get(i);
	}

	return convertedArray;

    }

    public static String[] stringList2Array(List<String> list)
    {
	int count = list.size();
	String[] convertedArray = new String[count];
	for (int i = 0; i < count; i++)
	{
	    convertedArray[i] = list.get(i);
	}

	return convertedArray;
    }

    
    public static List<String> stirngArray2List(String[] array)
    {
	List<String> convertedList = new ArrayList<String>();
	for (String obj : array)
	{
	    convertedList.add(obj);
	}

	return convertedList;

    }

    
    
}
