package ori.espressootr.test;
 

import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.collection.CollectionConverter;
import org.junit.Before;
import org.junit.Test;

public class UT_CollectionConverter_String
{
    
    String[] array = new String[5];
    List<String> list = new ArrayList<String>();

    

    @Before
    public void setUp() throws Exception
    {
	for (int i = 0; i < 5; i++)
	{
	    array[i] = String.valueOf(i);
	    list.add(String.valueOf(i));
	}
	
    }

    @Test
    public void test_ArrayToStringList()
    { 

	List<String> cnvList = CollectionConverter.stringArray2List(array);

	org.junit.Assert.assertEquals(5, cnvList.size());
	

	for(int i =0; i<cnvList.size(); i++)
	    org.junit.Assert.assertEquals(String.valueOf(i), cnvList.get(i));    
	
    }
    

    @Test
    public void test_StringListToArray()
    {

	String[] cnvArray = CollectionConverter.stringList2Array(list);

	org.junit.Assert.assertEquals(5, cnvArray.length);
	
	for(int i =0; i<cnvArray.length; i++)
	    org.junit.Assert.assertEquals(String.valueOf(i), cnvArray[i]);    
	    
    }
    
    

}
