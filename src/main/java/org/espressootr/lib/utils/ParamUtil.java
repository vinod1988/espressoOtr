package org.espressootr.lib.utils;

public class ParamUtil
{

  

    public static boolean isValidParams(final String... parameters)
    {
	boolean isValid = true;
	for (String param : parameters)
	{
	    if (isNull(param) || isZeroLength(param) || isWhiteSpace(param))
	    {
		isValid = false;
		break;
	    }
	}

	return isValid;
    }
    
    private static boolean isNull(final String param)
    {
	if(param==null)
	    return true; 
	else
	    return false; 
    }
    
    private static boolean isZeroLength(final String param)
    {
	if(param.length() == InitUtil.ZERO)
	    return true; 
	else
	    return false; 
    }
    
    
    
    private static boolean isWhiteSpace(final String param)
    {
	if(param.length() == 1 && param.equals(" "))
	    return true; 
	else
	    return false; 
    }
    
    
}
