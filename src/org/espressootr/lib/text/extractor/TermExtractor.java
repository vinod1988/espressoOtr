package org.espressootr.lib.text.extractor;

 
import java.util.List;

import org.espressootr.lib.collection.CollectionConverter;
import org.espressootr.lib.text.TextDiscriminator;
import org.espressootr.lib.utils.SplitterUtil;

public class TermExtractor
{ 

    public String[] extractTermsToArray(String target)
    {
	target = TextDiscriminator.replaceSymbolToSpace(target);
	target = TextDiscriminator.replaceWhiteSpaceToSpace(target);

	String[] terms = target.split(SplitterUtil.SPACE);
	return terms; 
    }

    public List<String> extractTermsToList(String target)
    {

	target = TextDiscriminator.replaceSymbolToSpace(target);
	target = TextDiscriminator.replaceWhiteSpaceToSpace(target);

	String[] terms = target.split(SplitterUtil.SPACE);

	return CollectionConverter.stringArray2List(terms);
	
    }

    public int extractTermCount(String target)
    {
        return extractTermsToArray(target).length;
    }
}
