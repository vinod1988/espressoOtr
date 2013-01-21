package org.espressootr.lib.string;

public class StringAppender
{
    
    static StringBuilder appender = new StringBuilder();
    
    public static String mergeToStr(String... targets)
    {
        clear();
        
        for (String target : targets)
        {
            appender.append(target);
        }
        
        return toStr();
    }
    
    public static void append(String... targets)
    {
        for (String target : targets)
        {
            appender.append(target);
        }
    }
    
    public static String toStr()
    {
        return appender.toString();
    }
    
    public static void clear()
    {
        appender.delete(0, appender.length());
    }
    
}
