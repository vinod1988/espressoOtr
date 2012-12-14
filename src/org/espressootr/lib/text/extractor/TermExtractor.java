package org.espressootr.lib.text.extractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.espressootr.lib.text.TextDiscriminator;
import org.espressootr.lib.utils.SplitterUtil;

public class TermExtractor
{

    public int extractTermCount(String target)
    {
	return extractTerms(target).length;
    }

    public String[] extractTerms(String target)
    {
	target = TextDiscriminator.replaceSymbolToSpace(target);
	target = TextDiscriminator.replaceWhiteSpaceToSpace(target);

	List<String> draftTermList = new ArrayList<String>(Arrays.asList(target.split(" ")));
	List<String> terms = new ArrayList<String>();

	for (String draftTerm : draftTermList)
	{
	    if (draftTerm.length() != 0)
		terms.add(draftTerm.trim());
	}

	String[] refinedTerms = terms.toArray(new String[terms.size()]);

	return refinedTerms;
    }

    public List<String> extractTermsToList(String target)
    {

	target = TextDiscriminator.replaceSymbolToSpace(target);
	target = TextDiscriminator.replaceWhiteSpaceToSpace(target);

	String[] terms = target.split(SplitterUtil.SPACE);

	List<String> termList = new ArrayList<String>();

	for (int i = 0; i < terms.length; i++)
	{
	    if (terms[i].length() != 0)
		termList.add(terms[i].trim());
	}

	return termList;
    }


}
