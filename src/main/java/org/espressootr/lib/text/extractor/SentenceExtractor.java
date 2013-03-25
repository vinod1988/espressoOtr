package org.espressootr.lib.text.extractor;

import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.text.TextDiscriminator; 

public class SentenceExtractor
{
    
    private char[] sentenceSeparator = { '.', '?', '!', '。' };
    
    private int sentenceMinLength = 16;
    
    public int extractSentenceCount(String document)
    {
        return extractSentences(document).size();
    }
    
    public List<String> extractSentences(final String document)
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
    
    private boolean checkRules(final StringBuilder candidateSentence)
    {
        boolean justSentence = true;
        
        int currentSentenceLength = candidateSentence.length();
        
        if (candidateSentence.length() <= sentenceMinLength)
        {
            justSentence = false;
        }
        
        if (currentSentenceLength > 2)
        {
            if (TextDiscriminator.isNumber(candidateSentence.charAt(currentSentenceLength - 2))) // n.
                justSentence = false;
        }
        
        return justSentence;
        
    }
    
}
