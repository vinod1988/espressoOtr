package org.espressootr.lib.file.filter;

import java.io.File;
import java.io.FilenameFilter;

import org.espressootr.lib.utils.InitUtil;

public class CustomFileFilter implements FilenameFilter
{

    private String target = InitUtil.EMPTY_STRING;
    private TargetType targetType = TargetType.ENDS_WITH;

    @SuppressWarnings("unused")
    private CustomFileFilter()
    {
	throw new AssertionError();
    }

    public CustomFileFilter(TargetType targetType, String target)
    {
	this.targetType = targetType;
	this.target = target;
    }

    @Override
    public boolean accept(File arg0, String fileName)
    {
	return isAccept(fileName);
    }

    private boolean isAccept(String fileName)
    {
	boolean accepted = false;
	if (this.targetType == TargetType.STARTS_WITH)
	{
	    accepted = fileName.toLowerCase().startsWith(target);

	}
	else if (this.targetType == TargetType.ENDS_WITH)
	{
	    accepted = fileName.toLowerCase().endsWith(target);
	}
	else
	{
	    accepted = fileName.toLowerCase().contains(target);
	}

	return accepted;
    }
}
