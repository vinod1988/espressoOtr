package org.espressootr.lib.text.jaso;

import org.espressootr.lib.lang.Korean;
 

public class JasoSeparator
{

    public static JasoLetter getJasoLetter(String target)
    {
        char[] targetCh = target.toCharArray();
        
        JasoLetter jasoLetter = new JasoLetter();
        
        int targetChSize = targetCh.length;
        for (int i = 0; i < targetChSize; i++)
        {
            
            if (Korean.isHangul(targetCh[i]))
            {// hangul
            
                int choIdx = 0;
                int jungIdx = 0;
                int jongIdx = 0;
                
                int init_char_idx = targetCh[i] - 0XAC00;
                
                jongIdx = (init_char_idx) % 28; // jong-sung
                jungIdx = ((init_char_idx - jongIdx) / 28) % 21; // jung-sung
                choIdx = (((init_char_idx) / 28) - jungIdx) / 21; // cho-sung
                
                jasoLetter.addChoSung(String.valueOf(Jaso.CHO_SUNG[choIdx]));
                
                jasoLetter.addJungSung(String.valueOf(Jaso.JUNG_SUNG[jungIdx]));
                
                if (jongIdx != 0x0000)
                {
                    jasoLetter.addJongSung(String.valueOf(Jaso.JONG_SUNG[jongIdx]));
                }
            }
            else
            {// not hangul
                jasoLetter.addEtc(String.valueOf(targetCh[i]));
            }
        }// for
        
        return jasoLetter;
        
    }
}
