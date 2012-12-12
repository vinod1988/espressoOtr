package org.espressootr.lib.text;

import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.collection.CollectionCoverter;
import org.espressootr.lib.utils.InitializerUtil;

public class FastSplitter
{

    private String target = InitializerUtil.EMPTY_STRING;

    public String getTarget()
    {
	return target;
    }

    public void setTarget(String target)
    {
	this.target = target;
    }

    public String[] splitToArray(char separator)
    {
	return CollectionCoverter.stringList2Array(splitToList(separator));
    }

    public List<String> splitToList(char separator)
    {
	List<String> splittedResult = new ArrayList<String>();

	char[] targetChars = this.target.toCharArray();

	StringBuilder mergedChars = new StringBuilder();

	for (char targetChar : targetChars)
	{
	    if (targetChar == separator)
	    {
		splittedResult.add(mergedChars.toString());
		mergedChars.delete(0, mergedChars.length());
	    }
	    else
	    {
		mergedChars.append(targetChar);
	    }

	}

	return splittedResult;

    }

    public String[] splitToArray(String separator)
    {

	// TODO:

	return null;
    }

    public List<String> splitToList(String separator)
    {
	// TODO :

	return null;
    }

}
