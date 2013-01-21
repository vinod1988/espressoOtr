package org.espressootr.test.ts;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.espressootr.test.UT_CollectionConverter_Integer;
import org.espressootr.test.UT_CollectionConverter_Object;
import org.espressootr.test.UT_CollectionConverter_String;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


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
