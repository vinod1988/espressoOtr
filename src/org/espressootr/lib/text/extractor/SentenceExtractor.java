package org.espressootr.lib.text.extractor;

import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.text.TextDiscriminator;
import org.espressootr.lib.text.TextRefiner;

public class SentenceExtractor
{

    private char[] sentenceSeparator = { '.', '?', '!', '。' };
    private TextRefiner txtRefiner = null;
    private int sentenceMinLength = 16;

    public SentenceExtractor()
    {
	txtRefiner = new TextRefiner(0);

    }

  

    public int extractSentenceCount(String document)
    {
	return extractSentences(document).size();
    }

    public List<String> extractSentences(String document)
    {
	List<String> sentences = new ArrayList<String>();

	StringBuilder tempStc = new StringBuilder();
	char[] docGrams = document.toCharArray();

	for (int i = 0; i < docGrams.length; i++)
	{
	    boolean isSentenceEnd = false;

	    for (int j = 0; j < sentenceSeparator.length; j++)
	    {
		if (docGrams[i] == sentenceSeparator[j])
		{
		    isSentenceEnd = true;
		}
	    }

	    if (isSentenceEnd == true)
	    {
		tempStc.append(docGrams[i]);
		if (checkRules(tempStc))
		{
		    sentences.add(tempStc.toString().trim());
		    tempStc.delete(0, tempStc.length());
		}
	    }
	    else
	    {
		tempStc.append(docGrams[i]);
	    }
	}// for

	if (sentences.size() == 0)
	{
	    sentences.add(tempStc.toString());
	}

	return sentences;
    }

    private boolean checkRules(StringBuilder candidateSentence)
    {
	boolean justSentence = true;

	int currentSentenceLength = candidateSentence.length();

	if (candidateSentence.length() <= sentenceMinLength)
	{// 문장분리기호 기준, 현재까지 문자열의 길이로 문장여부 판단.

	    justSentence = false;
	}

	if (currentSentenceLength > 2)
	{
	    if (TextDiscriminator.isNumber(candidateSentence.charAt(currentSentenceLength - 2))) // n.
	    { // 문장분리기호 위치에서 앞 문자가 숫자형인지를 검사, 숫자형이면 skip
		justSentence = false;

	    }
	}

	return justSentence;

    }

}
