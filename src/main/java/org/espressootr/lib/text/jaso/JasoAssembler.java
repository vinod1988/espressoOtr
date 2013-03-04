package org.espressootr.lib.text.jaso;

import java.util.ArrayList;
import java.util.List;

public class JasoAssembler
{
    
    public String assemblyJaso(String letter)
    {
        List<String> letterList = parseLetter(letter);
        return assemblyJasoLetter(letterList);
    }
    
    private List<String> parseLetter(String letter)
    {
        List<String> letterList = new ArrayList<String>();
        
        char[] letterChs = letter.toCharArray();
        
        for (char ch : letterChs)
        {
            letterList.add(String.valueOf(ch));
        }
        
        return letterList;
    }
    
    String assemblyJasoLetter(List<String> jasoLetter)
    {
        int willMergeLetterSize = jasoLetter.size();
        
        int[] index = new int[willMergeLetterSize];
        
        List<String> indexList = new ArrayList<String>();
        
        StringBuilder mergeSb = new StringBuilder();
        
        for (int i = 0; i < willMergeLetterSize; i++)
        {
            int jungIdx = Jaso.getIndexOfJungSung(jasoLetter.get(i).charAt(0));
            
            if (jungIdx == -1)
            {
                if ((i + 1) == willMergeLetterSize)
                {
                    index[i] = 2;
                }
                else
                {
                    if (Jaso.getIndexOfJungSung(jasoLetter.get(i + 1).charAt(0)) < 0)
                        index[i] = 2;
                    else
                        index[i] = 0;
                }
            }
            else
            {
                index[i] = 1;
            }
            
            int idx = 0;
            
            if (index[i] == 0 && mergeSb.length() > 0)
            {
                String saveString = mergeSb.toString();
                indexList.add(saveString.substring(0, saveString.length() - 1));
                
                mergeSb.delete(0, mergeSb.length());
            }
            
            if (index[i] == 0)
                idx = Jaso.getIndexOfChoSung(jasoLetter.get(i).charAt(0));
            else if (index[i] == 1)
                idx = Jaso.getIndexOfJungSung(jasoLetter.get(i).charAt(0));
            else if (index[i] == 2) idx = Jaso.getIndexOfJongSung(jasoLetter.get(i).charAt(0));
            
            mergeSb.append(String.valueOf(idx) + ";");
        }
        
        String saveString = mergeSb.toString();
        indexList.add(saveString.substring(0, saveString.length() - 1));
        mergeSb.delete(0, mergeSb.length());
        
        for (String indexer : indexList)
        {
            String[] splitedArray = indexer.split(";");
            
            int choIdx = Integer.parseInt(splitedArray[0]);
            int jungIdx = Integer.parseInt(splitedArray[1]);
            
            int jongIdx = 0;
            if (splitedArray.length == 3)
            {
                jongIdx = Integer.parseInt(splitedArray[2]);
            }
            char koreanLetter = (char) (0XAC00 + (choIdx * 21 * 28) + (jungIdx * 28) + jongIdx);
            
            mergeSb.append(koreanLetter);
        }
        
        return mergeSb.toString();
    }
}
