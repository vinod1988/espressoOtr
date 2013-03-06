package org.espressootr.unittest;
 

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.espressootr.lib.sort.ClassComparator;
import org.espressootr.lib.sort.QuickSort;
import org.junit.Before;
import org.junit.Test;

public class TestQuickSort
{
    List<Person> personList = new ArrayList<Person>();
    
    @Before
    public void setUp() throws Exception
    {
    
        Person p1 = new Person();
        
        p1.age = 10;
        p1.name = "ash84";
        p1.weight = 78;
        p1.birthDate = new Date( );
        
        Thread.sleep(1000);
        
        Person p2 = new Person();
        
        p2.age = 12;
        p2.name = "a1sh84";
        p2.weight = 78;
        p2.birthDate = new Date( );
        Thread.sleep(1000);
        
        Person p3 = new Person();
        
        p3.age = 9;
        p3.name = "a2sh84";
        p3.weight = 78;
        p3.birthDate = new Date( );
        
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
     
    }

   

    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testDateTypeInClassComparator()
    { 
        Comparator totalComapartor = new ClassComparator("birthDate", false); 
        Collections.sort(personList, totalComapartor);
       
        assertEquals(personList.get(0).name, "a2sh84"); 
        
    }
    

    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testStringInClassComparator()
    { 
        Comparator totalComapartor = new ClassComparator("name", false); 
        Collections.sort(personList, totalComapartor);
       
        assertEquals(personList.get(0).name, "ash84"); 
        
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testIntInClassComparator()
    { 
        Comparator totalComapartor = new ClassComparator("age", false); 
        Collections.sort(personList, totalComapartor);
        
         
    }

    
    
   
    @Test
    public void testStringComp()
    { 
        List<String> strList = new ArrayList<String>();
        
        strList.add("t");
        strList.add("a");
        
        QuickSort.sort(strList);
         
         
    }


}
