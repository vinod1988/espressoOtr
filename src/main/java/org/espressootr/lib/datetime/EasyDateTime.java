package org.espressootr.lib.datetime;

import java.text.SimpleDateFormat; 
import java.util.Date;

public class EasyDateTime
{
    
    public static String getNowString()
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        return simpleDateFormat.format(getNow()); 
    }
    
    public static Date getNow()
    {
        return new Date();
        
    }
    
}
