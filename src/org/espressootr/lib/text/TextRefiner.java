package org.espressootr.lib.text;

public class TextRefiner
{
    int refiningLevel = 0;

    public TextRefiner(int refiningLevel)
    {
	this.refiningLevel = refiningLevel;
    }

    public String refineText(String text)
    {
	String refinedText = null;

	if (this.refiningLevel == 0)
	{
	    refinedText = refineText1(text);
	}
	else if (this.refiningLevel == 1)
	{
	    refinedText = refineText2(text);
	}
	else
	{
	    refinedText = refineText3(text);
	}

	refinedText = TextDiscriminator.removeWhiteSpaceLetter(refinedText);

	return refinedText;
    }

    private String refineText1(String text)
    {

	StringBuilder sb = new StringBuilder();

	char[] grams = text.toCharArray();

	for (char gram : grams)
	{
	    if (TextDiscriminator.isHangul(gram) || TextDiscriminator.isAlphabet(gram) || TextDiscriminator.isNumber(gram))
	    {
		sb.append(gram);
	    }
	}

	return sb.toString();
    }

    private String refineText2(String text)
    {
	StringBuilder sb = new StringBuilder();

	char[] grams = text.toCharArray();

	for (char gram : grams)
	{
	    if (TextDiscriminator.isHangul(gram) || TextDiscriminator.isAlphabet(gram))
	    {
		sb.append(gram);
	    }

	}

	return sb.toString();
    }

    private String refineText3(String text)
    {

	StringBuilder sb = new StringBuilder();

	char[] grams = text.toCharArray();

	for (char gram : grams)
	{
	    if (TextDiscriminator.isHangul(gram))
	    {
		sb.append(gram);
	    }
	}

	return sb.toString();

    }

}
