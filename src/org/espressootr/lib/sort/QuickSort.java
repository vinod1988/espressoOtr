package org.espressootr.lib.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSort
{
    public static void sort(List<String> sortingTarget)
    {
	Comparator<String> comparator = new Comparator<String>()
	{

	    public int compare(String arg0, String arg1)
	    {

		if (arg0 == null || arg1 == null)
		{
		    return 0;
		}

		return arg0.compareTo(arg1);
	    }
	};

	Collections.sort(sortingTarget, comparator);

    } 

}
