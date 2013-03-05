package org.espressootr.lib.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSort
{
    
    private static final Comparator<String> stringComp = new Comparator<String>() {
        
        public int compare(String arg0, String arg1)
        {
            
            if (arg0 == null || arg1 == null) { return 0; }
            
            return arg0.compareTo(arg1);
        }
    };
    
    private static final Comparator<Integer> intAscComp = new Comparator<Integer>() {
        
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
    
    private static final Comparator<Integer> intDescComp = new Comparator<Integer>() {
        
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
    
    public static final void sort(List<String> sortingTarget)
    {
        
        Collections.sort(sortingTarget, stringComp);
        
    }
    
    public static final void sortByAsc(List<Integer> sortingTarget)
    {
        Collections.sort(sortingTarget, intAscComp);
    }
    
    public static final void sortByDesc(List<Integer> sortingTarget)
    {
        
        Collections.sort(sortingTarget, intDescComp);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static final void sort(List<Object> sortingTarget, String sortingField, boolean ascending)
    {
        
        Comparator totalComapartor = new ClassComparator(sortingField, ascending);
        
        Collections.sort(sortingTarget, totalComapartor);
    }
}
