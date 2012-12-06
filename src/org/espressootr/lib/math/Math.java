package org.espressootr.lib.math;

import java.util.List;

public class Math
{

    public static int getMaxValue(int[] source)
    {
	int maxValue = -2147483648;
	for (int i = 0; i < source.length; i++)
	{
	    if (maxValue < source[i])
	    {
		maxValue = source[i];
	    }
	 
	}

	return maxValue;

    }
    
    public static int getMaxValue(List<Integer> source)
    {
	int maxValue = -2147483648;
	for (int i = 0; i < source.size(); i++)
	{
	    if (maxValue < source.get(i))
	    {
		maxValue = source.get(i);
	    }
	 
	}

	return maxValue;

    }
    
    

    public static int getMinValue(int[] source)
    {
	int minValue = 2147483647;
	for (int i = 0; i < source.length; i++)
	{
	    if (minValue > source[i])
	    {
		minValue = source[i];
	    }
	 
	}

	return minValue;

    }
    
    public static int getMinValue(List<Integer> source)
    {
	int minValue = 2147483647;
	for (int i = 0; i < source.size(); i++)
	{
	    if (minValue > source.get(i))
	    {
		minValue = source.get(i);
	    }
	 
	}

	return minValue;

    }
    
    
    
    
}
