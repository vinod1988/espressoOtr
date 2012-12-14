package org.espressootr.lib.text;

import org.espressootr.lib.lang.English;
import org.espressootr.lib.lang.Korean;
import org.espressootr.lib.lang.Number;
import org.espressootr.lib.lang.Chinese;
import org.espressootr.lib.utils.InitUtil;
import org.espressootr.lib.utils.SplitterUtil;

public class TextDiscriminator
{

    public static boolean isHangul(char gram)
    {
	return Korean.isHangul(gram);

    }

    public static boolean isNumber(char gram)
    {
	return Number.isNumber(gram);

    }

    public static boolean isAlphabet(char gram)
    {
	return English.isEnglish(gram);
    }

    public static boolean isChinese(char gram)
    {
	return Chinese.isChinese(gram);
    }

    public static boolean isWhiteSpace(char gram)
    {
	boolean isWSGram = false;

	if (gram == ' ')
	    isWSGram = true;
	else
	    isWSGram = false;

	return isWSGram;
    }

    public static String removeWhiteSpaceLetter(String text)
    {
	text = text.replace(SplitterUtil.TAB, InitUtil.EMPTY_STRING);
	text = text.replace(SplitterUtil.CR, InitUtil.EMPTY_STRING);
	text = text.replace(SplitterUtil.LF, InitUtil.EMPTY_STRING);
	text = text.replace(SplitterUtil.SPACE, InitUtil.EMPTY_STRING);

	return text;
    }

    public static String replaceWhiteSpaceToSpace(String text)
    {
	text = text.replace(SplitterUtil.TAB, SplitterUtil.SPACE);
	text = text.replace(SplitterUtil.CR, SplitterUtil.SPACE);
	text = text.replace(SplitterUtil.LF, SplitterUtil.SPACE);

	return text;
    }

    public static String replaceSymbolToSpace(String text)
    {
	StringBuilder sb = new StringBuilder();

	char[] grams = text.toCharArray();

	for (char gram : grams)
	{
	    if (isHangul(gram) || isAlphabet(gram) || isNumber(gram) || isWhiteSpace(gram))
	    {
		sb.append(gram);
	    }
	}

	return sb.toString();
    }

}
