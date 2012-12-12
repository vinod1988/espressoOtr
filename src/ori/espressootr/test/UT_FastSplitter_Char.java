package ori.espressootr.test;


import java.util.List;

import org.espressootr.lib.text.FastSplitter;
import org.junit.Before;
import org.junit.Test;

public class UT_FastSplitter_Char
{

    char separator = ':';
    FastSplitter fSplitter = new FastSplitter(separator);

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test_exact_separating()
    {

	String target = "tumblr : starbucks";

	List<String> splittedTarget = fSplitter.splitToList(target);
	org.junit.Assert.assertEquals(2, splittedTarget.size());
	org.junit.Assert.assertEquals("tumblr", splittedTarget.get(0).trim());
	org.junit.Assert.assertEquals("starbucks", splittedTarget.get(1).trim());

    }
    

    @Test
    public void test_trim_option_true()
    {

	String target = "tumblr : starbucks";

	fSplitter.setTrim(true);
	List<String> splittedTarget = fSplitter.splitToList(target);
	org.junit.Assert.assertEquals(2, splittedTarget.size());
	org.junit.Assert.assertEquals("tumblr", splittedTarget.get(0));
	org.junit.Assert.assertEquals("starbucks", splittedTarget.get(1));

    }
    
    @Test
    public void test_trim_option_false()
    {

	String target = "tumblr : starbucks";

	fSplitter.setTrim(false);
	List<String> splittedTarget = fSplitter.splitToList(target);
	org.junit.Assert.assertEquals(2, splittedTarget.size());
	org.junit.Assert.assertEquals("tumblr ", splittedTarget.get(0));
	org.junit.Assert.assertEquals(" starbucks", splittedTarget.get(1));

    }

}
