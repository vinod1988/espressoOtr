package org.espressootr.lib.text;

import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.collection.CollectionCoverter;
import org.espressootr.lib.utils.InitializerUtil;

public class FastSplitter
{

    private char separator = InitializerUtil.EMPTY_CHAR;
    private boolean isTrim = false;

    @SuppressWarnings("unused")
    private FastSplitter()
    {
	throw new AssertionError();

    }

    public FastSplitter(char separator)
    {
	this.separator = separator;
    }

    public char getSeparator()
    {
	return separator;
    }

    public void setSeparator(char separator)
    {
	this.separator = separator;
    }

    public void setTrim(boolean isTrim)
    {
	this.isTrim = isTrim;

    }

    public String[] splitToArray(String target)
    {
	return CollectionCoverter.stringList2Array(splitToList(target));
    }

    public List<String> splitToList(String target)
    {
	List<String> splittedResult = new ArrayList<String>();

	char[] targetChars = target.toCharArray();

	StringBuilder mergedChars = new StringBuilder();

	String willInsertString = "";
	for (char targetChar : targetChars)
	{
	    if (targetChar == this.separator)
	    {
		if (isTrim)
		    willInsertString = mergedChars.toString().trim();
		else
		    willInsertString = mergedChars.toString();

		splittedResult.add(willInsertString);
		mergedChars.delete(0, mergedChars.length());
	    }
	    else
	    {
		mergedChars.append(targetChar);
	    }

	}

	if (isTrim)
	    willInsertString = mergedChars.toString().trim();
	else
	    willInsertString = mergedChars.toString();

	splittedResult.add(willInsertString);

	return splittedResult;

    }

}
