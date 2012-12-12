package ori.espressootr.test.ts;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ori.espressootr.test.UT_CollectionConverter_Integer;
import ori.espressootr.test.UT_CollectionConverter_Object;
import ori.espressootr.test.UT_CollectionConverter_String;

@RunWith(Suite.class)
@SuiteClasses({ UT_CollectionConverter_Integer.class, UT_CollectionConverter_Object.class, UT_CollectionConverter_String.class })
public class TS_CollectionConverter
{
    public static Test suite()
    {

	TestSuite suite = new TestSuite();

	return suite;

    }

}
