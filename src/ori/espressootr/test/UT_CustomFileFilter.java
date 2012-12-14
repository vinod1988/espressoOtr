package ori.espressootr.test;

import static org.junit.Assert.*;

import org.espressootr.lib.file.filter.CustomFileFilter;
import org.espressootr.lib.file.filter.TargetType;
import org.junit.Before;
import org.junit.Test;

public class UT_CustomFileFilter
{

    String fileName = "test-main.cpp";

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test_STARTS_WITH()
    {
	String target = "test";

	CustomFileFilter customFilter = new CustomFileFilter(TargetType.STARTS_WITH, target);

	assertEquals(true, customFilter.accept(null, fileName));

    }

    @Test
    public void test_ENDS_WITH()
    {
	String target = "cpp";

	CustomFileFilter customFilter = new CustomFileFilter(TargetType.ENDS_WITH, target);

	assertEquals(true, customFilter.accept(null, fileName));

    }

    @Test
    public void test_CONTAINS()
    {
	String target = "-main";

	CustomFileFilter customFilter = new CustomFileFilter(TargetType.CONTAINS, target);

	assertEquals(true, customFilter.accept(null, fileName));

    }

}
