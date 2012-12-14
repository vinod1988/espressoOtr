package ori.espressootr.test;
 

import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.collection.CollectionConverter;
import org.junit.Before;
import org.junit.Test;

public class UT_CollectionConverter_Integer
{
    int[] array = new int[5];
    List<Integer> list = new ArrayList<Integer>();

    @Before
    public void setUp() throws Exception
    {
	for (int i = 0; i < 5; i++)
	{
	    array[i] = i;
	    list.add(i);
	}
    }

    @Test
    public void test_ArrayToIntegerList()
    {

	List<Integer> cnvList = CollectionConverter.intArray2List(array);

	org.junit.Assert.assertEquals(5, cnvList.size());
	
	for(int i =0; i<cnvList.size(); i++)
	    org.junit.Assert.assertEquals(Integer.valueOf(i), cnvList.get(i));    
    }

    @Test
    public void test_IntegerListToArray()
    {
	int[] cnvArray = CollectionConverter.intList2Array(list);

	org.junit.Assert.assertEquals(5, cnvArray.length);
	
	for(int i =0; i<cnvArray.length; i++)
	    org.junit.Assert.assertEquals(i, cnvArray[i]);    
	    
	
    }
}
