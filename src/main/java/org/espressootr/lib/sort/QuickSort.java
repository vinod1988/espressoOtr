package org.espressootr.lib.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSort
{
    public static void sort(List<String> sortingTarget)
    {
        Comparator<String> comparator = new Comparator<String>() {
            
            public int compare(String arg0, String arg1)
            {
                
                if (arg0 == null || arg1 == null) { return 0; }
                
                return arg0.compareTo(arg1);
            }
        };
        
        Collections.sort(sortingTarget, comparator);
        
    }
    
    public static void sortByAsc(List<Integer> sortingTarget)
    {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            
            public int compare(Integer arg0, Integer arg1)
            {
                
                int result = 0;
                
                if (arg0 < arg1)
                {
                    result = -1;
                }
                else if (arg0 > arg1)
                {
                    result = 1;
                }
                else
                {
                    result = 0;
                }
                
                return result;
            }
            
        };
        
        Collections.sort(sortingTarget, comparator);
    }
    
    public static void sortByDesc(List<Integer> sortingTarget)
    {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            
            public int compare(Integer arg0, Integer arg1)
            {
                
                int result = 0;
                
                if (arg0 < arg1)
                {
                    result = 1;
                }
                else if (arg0 > arg1)
                {
                    result = -1;
                }
                else
                {
                    result = 0;
                }
                
                return result;
            }
            
        };
        
        Collections.sort(sortingTarget, comparator);
    }
    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void sort(List<Object> sortingTarget, String sortingField, boolean ascending)
    { 
        
        Comparator totalComapartor = new ClassComparator(sortingField, ascending);
        
        Collections.sort(sortingTarget, totalComapartor);
    }
}
