package org.espressootr.lib.debug;

public class Debug
{
    public static String getMethodName()
    {
	StackTraceElement[] elements = null;

	try
	{
	    throw new Exception("getMethodName");
	}
	catch (Exception e)
	{
	    elements = e.getStackTrace();
	}

	String methodName = ((StackTraceElement) elements[1]).getMethodName();

	return methodName;
    }
}
