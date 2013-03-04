package org.espressootr.lib.text;

public class TextRefiner
{
    int refiningLevel = 0;
    
    public TextRefiner(int refiningLevel)
    {
        this.refiningLevel = refiningLevel;
    }
    
    public String refineText(String text) throws Exception
    {
        String refinedText = null;
        
        if (this.refiningLevel == 0)
        {
            refinedText = refineTextHangulEnglishNumber(text);
        }
        else if (this.refiningLevel == 1)
        {
            refinedText = refineTextHangulEnglish(text);
        }
        else if(this.refiningLevel == 2)
        {
            refinedText = refineTextHangulOnly(text);
        }
        else
        {
            throw new Exception("Wrong Refine Text Level.");
        }
        
        refinedText = TextDiscriminator.removeWhiteSpaceLetter(refinedText);
        
        return refinedText;
    }
    
    private String refineTextHangulEnglishNumber(String text)
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
    
    private String refineTextHangulEnglish(String text)
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
    
    private String refineTextHangulOnly(String text)
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
