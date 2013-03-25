package org.espressootr.lib.sort;

import java.util.Comparator;
import java.util.Date;

import org.espressootr.lib.utils.InitUtil;

@SuppressWarnings("rawtypes")
public class ClassComparator implements Comparator
{
    String sortingField = InitUtil.EMPTY_STRING;
    
    boolean ascending = true;
    
    @SuppressWarnings("unused")
    private ClassComparator()
    {
        throw new AssertionError();
    }
    
    public ClassComparator(final String field, final boolean ascending)
    {
        this.sortingField = field;
        this.ascending = ascending; 
    }
    
    @Override
    public int compare(final Object o1,final Object o2)
    {
        int result = 0;
        
        try
        { 
            Class<?> fieldType = o1.getClass().getField(this.sortingField).getType();
            
            if (fieldType == int.class)
            {
                if (this.ascending)
                {
                    result = compareIntAsc(o1, o2);
                }
                else
                {
                    result = compareIntDesc(o1, o2);
                }
            }
            else if (fieldType == java.lang.String.class)
            {
                if (this.ascending)
                {
                    result = compareStringAsc(o1, o2);
                }
                else
                {
                    result = compareStringDesc(o1, o2);
                }
                
            }
            else if (fieldType == java.util.Date.class)
            {
                if (this.ascending)
                {
                    result = compareDateAsc(o1, o2);
                }
                else
                {
                    result = compareDateDesc(o1, o2);
                }
                
            }
            else
            {
                throw new Exception("no supporting type "+fieldType);
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
        
    }
    
    private int compareIntAsc(final Object o1, final Object o2)
    {
        int result = 0;
        
        try
        {
            int o1IntValue = o1.getClass().getField(this.sortingField).getInt(o1);
            int o2IntValue = o2.getClass().getField(this.sortingField).getInt(o2);
            
            if (o1IntValue < o2IntValue)
            {
                result = -1;
            }
            else if (o1IntValue > o2IntValue)
            {
                result = 1;
            }
            else
            {
                result = 0;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            
        }
        
        return result;
    }
    
    private int compareIntDesc(final Object o1, final Object o2)
    {
        int result = 0;
        
        try
        {
            int o1IntValue = o1.getClass().getField(this.sortingField).getInt(o1);
            int o2IntValue = o2.getClass().getField(this.sortingField).getInt(o2);
            
            if (o1IntValue > o2IntValue)
            {
                result = -1;
            }
            else if (o1IntValue < o2IntValue)
            {
                result = 1;
            }
            else
            {
                result = 0;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            
        }
        
        return result;
    }
    
    private int compareStringAsc(final Object o1, final Object o2)
    {
        int result = 0;
        
        try
        {
            String o1StrValue = (String) o1.getClass().getField(this.sortingField).get(o1);
            String o2StrValue = (String) o2.getClass().getField(this.sortingField).get(o2);
            
            result = o1StrValue.compareTo(o2StrValue);
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            
        }
        
        return result;
    }
    
    private int compareStringDesc(final Object o1, final Object o2)
    {
        int result = 0;
        
        try
        {
            String o1StrValue = (String) o1.getClass().getField(this.sortingField).get(o1);
            String o2StrValue = (String) o2.getClass().getField(this.sortingField).get(o2);
            
            result = o2StrValue.compareTo(o1StrValue);
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            
        }
        
        return result;
    }
    
    private int compareDateAsc(final Object o1, final Object o2)
    {
        int result = 0;
        
        try
        {
            Date o1DateValue = (Date) o1.getClass().getField(this.sortingField).get(o1);
            Date o2DateValue = (Date) o2.getClass().getField(this.sortingField).get(o2);
            
            result = o1DateValue.compareTo(o2DateValue);
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            
        }
        
        return result;
    }
    
    private int compareDateDesc(final Object o1, final Object o2)
    {
        int result = 0;
        
        try
        {
            Date o1DateValue = (Date) o1.getClass().getField(this.sortingField).get(o1);
            Date o2DateValue = (Date) o2.getClass().getField(this.sortingField).get(o2);
            
            result = o2DateValue.compareTo(o1DateValue);
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            
        }
        
        return result;
    }
    
}
