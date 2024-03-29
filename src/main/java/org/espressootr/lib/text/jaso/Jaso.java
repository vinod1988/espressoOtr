package org.espressootr.lib.text.jaso;

public class Jaso
{
    static final char[] CHO_SUNG = { 0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145, 0x3146, 0x3147, 0x3148, 0x3149,
            0x314a, 0x314b, 0x314c, 0x314d, 0x314e };
    
    static final char[] JUNG_SUNG = { 0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158, 0x3159, 0x315a, 0x315b, 0x315c,
            0x315d, 0x315e, 0x315f, 0x3160, 0x3161, 0x3162, 0x3163 };
    
    static final char[] JONG_SUNG = { 0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a, 0x313b, 0x313c, 0x313d, 0x313e,
            0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145, 0x3146, 0x3147, 0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };
    
    public static int getIndexOfChoSung(char cho)
    {
        int choIdx = -1;
        
        for (int j = 0; j < CHO_SUNG.length; j++)
        {
            if (CHO_SUNG[j] == cho)
            {
                choIdx = j;
                break;
            }
            
        }
        
        return choIdx;
    }
    
    public static int getIndexOfJungSung(char jung)
    {
        int jungIdx = -1;
        
        for (int j = 0; j < JUNG_SUNG.length; j++)
        {
            if (JUNG_SUNG[j] == jung)
            {
                jungIdx = j;
                break;
            }
            
        }
        
        return jungIdx;
    }
    
    public static int getIndexOfJongSung(char jong)
    {
        int jongIdx = -1;
        
        for (int j = 0; j < JONG_SUNG.length; j++)
        {
            if (JONG_SUNG[j] == jong)
            {
                jongIdx = j;
                break;
            }
            
        }
        
        return jongIdx;
    }
    
}
